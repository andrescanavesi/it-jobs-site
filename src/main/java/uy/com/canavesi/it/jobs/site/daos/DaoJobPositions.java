package uy.com.canavesi.it.jobs.site.daos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import uy.com.canavesi.it.jobs.site.entities.JobPosition;
import uy.com.canavesi.it.jobs.site.exceptions.DatabaseConfigurationException;
import uy.com.canavesi.it.jobs.site.util.DbHelper;

/**
 *
 * @author Andres Canavesi
 */
public class DaoJobPositions implements Serializable {

    private static final Logger LOG = Logger.getLogger(DaoJobPositions.class.getName());
    private static final String SCHEMA = "\"salesforce\"";
    //private static final String TABLE_NAME = SCHEMA + ".\"jobposition__c\"";
    private static final String TABLE_NAME = "\"jobposition__c\"";

    public DaoJobPositions() {
    }

    private JobPosition convertToJobPosition(ResultSet resultSet) throws SQLException, ParseException {

        JobPosition jobPosition = new JobPosition();

        jobPosition.setId(resultSet.getLong("id"));
        String createdAt = resultSet.getString("createddate");
        DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (createdAt != null) {
            jobPosition.setCreatedDate(DATE_FORMAT.parse(createdAt));
        }

        jobPosition.setTitle(resultSet.getString("title__c"));
        jobPosition.setDescription(resultSet.getString("description__c"));
        jobPosition.setRemote(resultSet.getBoolean("remote__c"));
        return jobPosition;
    }

    /**
     *
     * @param start
     * @param end
     * @return
     * @throws Exception
     */
    public List<JobPosition> find(int start, int end) throws Exception {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DbHelper.getInstance().getConnection();

            //String query = "SELECT * FROM " + TABLE_NAME + " WHERE isdeleted = ? ORDER BY createddate DESC";
            String query = "SELECT * FROM \"salesforce\".\"jobposition__c\" WHERE isdeleted = ? ORDER BY createddate DESC";
            LOG.log(Level.INFO, "\n{0}", query);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setBoolean(1, false);

            preparedStatement.setMaxRows(DaoConfigs.getPageSizeDB());
            preparedStatement.setFetchSize(DaoConfigs.getPageSizeDB());
            resultSet = preparedStatement.executeQuery();

            List<JobPosition> jobPositions = new ArrayList<>();
            while (resultSet.next()) {
                JobPosition jobPosition = convertToJobPosition(resultSet);
                jobPositions.add(jobPosition);
            }
            preparedStatement.close();

            return jobPositions;
        } catch (DatabaseConfigurationException | SQLException | ParseException e) {
            throw e;
        } finally {
            DbHelper.tryToCloseResources(resultSet, preparedStatement, connection);
        }

    }

}
