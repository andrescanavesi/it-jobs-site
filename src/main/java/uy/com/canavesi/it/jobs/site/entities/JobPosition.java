package uy.com.canavesi.it.jobs.site.entities;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Andres Canavesi
 */
public class JobPosition implements Serializable {

    private Long id;
    private String title;
    private String description;
    private String city;
    private String company;
    private Boolean remote;
    private Date createdDate;
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/ddd");

    /**
     *
     */
    public JobPosition() {
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

    /**
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return
     */
    public String getCompany() {
        return company;
    }

    /**
     *
     * @param company
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     *
     * @return
     */
    public Boolean getRemote() {
        return remote;
    }

    /**
     *
     * @param remote
     */
    public void setRemote(Boolean remote) {
        this.remote = remote;
    }

    /**
     *
     * @return
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     *
     * @param createdDate
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     *
     * @return
     */
    public String getCreatedDateFormatted() {
        return DATE_FORMAT.format(createdDate);
    }

}
