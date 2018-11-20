package uy.com.canavesi.it.jobs.site.entities;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Andres Canavesi
 */
public class JobApplication implements Serializable {

    private Long id;
    private String resumeUrl;
    private String name;
    private String lastName;
    private String email;
    private String linkedinUrl;
    private Date birthdate;
    private Long jobPositionSalesforceId;

    /**
     *
     */
    public JobApplication() {
    }

    public String getExternalId() {
        return name + "-" + lastName + "-" + jobPositionSalesforceId;
    }

    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    public String getResumeUrl() {
        return resumeUrl;
    }

    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Long getJobPositionSalesforceId() {
        return jobPositionSalesforceId;
    }

    public void setJobPositionSalesforceId(Long jobPositionSalesforceId) {
        this.jobPositionSalesforceId = jobPositionSalesforceId;
    }

}
