package uy.com.canavesi.it.jobs.site.web;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

/**
 *
 * @author andrescanavesi
 */
@Named(value = "appManagedBean")
@ApplicationScoped
@ManagedBean
public class AppManagedBean {

    /**
     *
     */
    public AppManagedBean() {
    }

    /**
     *
     */
    @PostConstruct
    public void init() {

    }

}
