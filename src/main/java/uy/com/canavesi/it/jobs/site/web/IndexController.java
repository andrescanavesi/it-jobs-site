package uy.com.canavesi.it.jobs.site.web;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import uy.com.canavesi.it.jobs.site.daos.DaoConfigs;
import uy.com.canavesi.it.jobs.site.daos.DaoJobPositions;
import uy.com.canavesi.it.jobs.site.entities.JobPosition;

/**
 * index.xhtml controller
 *
 * @author Andres Canavesi
 */
@Named(value = "indexManagedBean")
@ViewScoped
@ManagedBean
public class IndexController {

    private static final Logger LOG = Logger.getLogger(IndexController.class.getName());

    private Boolean isProduction;

    private String baseUrl;
    private List<JobPosition> jobPositions;
    private DaoJobPositions daoJobPositions;
    private Boolean error = false;

    /**
     *
     */
    @PostConstruct
    public void init() {
        LOG.info("Init");
        try {
            isProduction = DaoConfigs.isProduction();
            baseUrl = DaoConfigs.getBaseUrl();

            daoJobPositions = new DaoJobPositions();
            jobPositions = daoJobPositions.find(0, 100);//TODO implement pagination
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage(), e);
            error = true;
        }
    }

    /**
     *
     * @return
     */
    public Boolean getIsProduction() {
        return isProduction;
    }

    /**
     *
     * @return
     */
    public String getBaseUrl() {
        return baseUrl;
    }

    /**
     *
     * @return
     */
    public List<JobPosition> getJobPositions() {
        return jobPositions;
    }

    /**
     *
     * @param jobPositions
     */
    public void setJobPositions(List<JobPosition> jobPositions) {
        this.jobPositions = jobPositions;
    }

    /**
     *
     * @return
     */
    public Boolean getError() {
        return error;
    }

}
