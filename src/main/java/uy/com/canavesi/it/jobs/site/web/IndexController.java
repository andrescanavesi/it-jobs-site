package uy.com.canavesi.it.jobs.site.web;

import java.util.Map;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import uy.com.canavesi.it.jobs.site.daos.DaoConfigs;

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

    /**
     *
     */
    @PostConstruct
    public void init() {
        LOG.info("Init");
        isProduction = DaoConfigs.isProduction();
        baseUrl = DaoConfigs.getBaseUrl();

        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();

    }

    public Boolean getIsProduction() {
        return isProduction;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

}
