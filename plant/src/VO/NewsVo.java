package VO;

import java.util.Date;

public class NewsVo {

    private String id;
    
    private String title;
    
    private String content;
    
    private Date createdTime;
    
    private int viewedCount;
    
    private String newsImgURL;

    public String getNewsImgURL() {
        return newsImgURL;
    }

    public void setNewsImgURL(String newsImgURL) {
        this.newsImgURL = newsImgURL;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
