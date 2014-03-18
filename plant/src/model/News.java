package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "news")
public class News extends BaseModel{

    private static final long serialVersionUID = 2466669338613311591L;

    @Column(name = "title", length = 100, nullable = false)
    private String title;
    
    @Column(name = "content", length = 5000, nullable = false)
    private String content;
    
    @Column(name = "viewed_count", length = 50, nullable = false, columnDefinition="INT default 0")
    private int viewedCount;
            
    private String newsImgURL;

    public String getNewsImgURL() {
        return newsImgURL;
    }

    public void setNewsImgURL(String newsImgURL) {
        this.newsImgURL = newsImgURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getViewedCount() {
        return viewedCount;
    }

    public void setViewedCount(int viewedCount) {
        this.viewedCount = viewedCount;
    }
    
}
