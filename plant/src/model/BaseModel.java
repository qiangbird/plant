package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * The base model which all the models contains these columns
 * @author John.Li
 * @time Dec 21, 2013
 *
 */
@MappedSuperclass
public class BaseModel implements Serializable{

    private static final long serialVersionUID = 7003375317247018388L;

    /**
     * The id of the record
     */
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(length = 32)
    private String id;
    
    /**
     * The create time of the record
     */
    @Column(name = "created_time", nullable = false)
    private Date createdTime;
 
    /**
     * The update time of the record
     */
    @Column(name = "updated_time", nullable = false)
    private Date updatedTime;
    
    /**
     * A mark that define whether the record be deleted
     */
    @Column(name = "is_expired", insertable = false, nullable = false, columnDefinition = "bit(1) default 0")
    private boolean isExpired;

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean isExpired) {
        this.isExpired = isExpired;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
