package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User extends BaseModel {

    private static final long serialVersionUID = 8364239647574512618L;

    @Column(name = "name", length = 50, nullable = false)
    private String name;
    
    @Column(name = "password", length = 100, nullable = false)
    private String password;
    
    @Column(name = "email", length = 50, nullable = false)
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
