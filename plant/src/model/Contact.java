package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "contact")
public class Contact extends BaseModel{

    private static final long serialVersionUID = 8736938293607139805L;

    @Column(name = "name", length = 50, nullable = false)
    private String name;
    
    @Column(name = "telephone", length = 20, nullable = false)
    private String telephone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
}
