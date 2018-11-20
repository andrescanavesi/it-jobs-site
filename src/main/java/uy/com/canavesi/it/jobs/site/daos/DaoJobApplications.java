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
import uy.com.canavesi.it.jobs.site.entities.JobApplication;
import uy.com.canavesi.it.jobs.site.entities.JobPosition;
import uy.com.canavesi.it.jobs.site.exceptions.DatabaseConfigurationException;
import uy.com.canavesi.it.jobs.site.util.DbHelper;

/**
 *
 * @author Andres Canavesi
 */
public class DaoJobApplications implements Serializable {

    private static final Logger LOG = Logger.getLogger(DaoJobApplications.class.getName());
    private static final String SCHEMA = "\"salesforce\"";
    private static final String TABLE_NAME = SCHEMA + ".\"jobapplication__c\"";

    /**
     *
     */
    public DaoJobApplications() {
    }

    /**
     *
     * @param jobApplication
     * @throws Exception
     */
    public void create(JobApplication jobApplication) throws Exception {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DbHelper.getInstance().getConnection();

            String statement = "INSERT INTO " + TABLE_NAME + "(\"resumeurl_c\", \"lastname__c\", \"email__c\", \"name__c\", \"linkedin_url__c\", \"birthdate__c\", "
                    + "\"jobposition__c\", \"external__c\") "
                    + "VALUES(?,?,?,?,?,?,?,?);";
            LOG.log(Level.INFO, "\n{0}", statement);
            preparedStatement = connection.prepareStatement(statement);

            preparedStatement.setString(1, jobApplication.getResumeUrl());
            //TODO add more fields

            int result = preparedStatement.executeUpdate();
            if (result == 0) {
                throw new Exception("Error inserting the job application");
            }
            LOG.info("\nRule was inserted");

            preparedStatement.close();

        } catch (DatabaseConfigurationException | SQLException | ParseException e) {
            throw e;
        } finally {
            DbHelper.tryToCloseResources(resultSet, preparedStatement, connection);
        }

    }

}
