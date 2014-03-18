package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "leave_word")
public class LeaveWord extends BaseModel{

    private static final long serialVersionUID = 8242422869064630001L;

    @Column(name = "title", length = 128, nullable = false)
    private String title;
    
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    
    @Column(name = "telephone", length = 20, nullable = false)
    private String telephone;

    @Column(name = "email", length = 50)
    private String email;
    
    @Column(name = "qq", length = 20)
    private String qq;
    
    @Column(name = "content", length = 500, nullable = false)
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
}
