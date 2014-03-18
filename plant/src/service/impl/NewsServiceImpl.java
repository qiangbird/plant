package service.impl;

import java.util.List;

import model.News;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import service.NewsService;
import VO.NewsVo;
import dao.NewsDao;

@Repository("newsService")
public class NewsServiceImpl implements NewsService{

    private Logger logger = Logger.getLogger(NewsServiceImpl.class);
    
    @Autowired
    private NewsDao newsDao;
    
    /* (non-Javadoc)
     * @see service.NewsService#saveNews(VO.NewsVo)
     */
    @Override
    public void saveNews(NewsVo newsVo){
        
        logger.info("start...");
        
        News news = new News();
        
        news.setTitle(newsVo.getTitle());
        news.setContent(newsVo.getContent());
        news.setNewsImgURL(newsVo.getNewsImgURL());
        
        newsDao.save(news);
        
        logger.info("end...");
    }

    /* (non-Javadoc)
     * @see service.NewsService#getNews(VO.NewsVo)
     */
    @Override
    public JSONObject getNews(NewsVo newsVo) {
        
        logger.info("start...");
        
        News news = newsDao.get(News.class, newsVo.getId());
        
        JSONObject object = new JSONObject();
        
        object.put("newsId", news.getId());
        object.put("title", news.getTitle());
        object.put("content", news.getContent());
        object.put("newsImgURL", news.getNewsImgURL());
        object.put("viewedCount", news.getViewedCount());
        object.put("createdTime", news.getCreatedTime().toString());
        
        updateViewedCount(news);
        
        logger.info("end...");
        return object;
    }
    
    //Update the viewedCount of the news
    private void updateViewedCount(News news){
        
        logger.info("updateViewedCount start...");
        
        //update the viewedCount of the news
        int currentCount =  news.getViewedCount();
        news.setViewedCount(currentCount + 1);
        
        newsDao.update(news);
        
        logger.info("updateViewedCount end...");
    }

    @Override
    public List<News> findNews() {
        
        logger.info("start...");
        
        List<News> newses = newsDao.findAll(News.class);
        
        logger.info("end...");
        
        return newses;
        
    }

    @Override
    public void updateNews(NewsVo newsVo) {
        
        logger.info("start...");
        
        News news = newsDao.get(News.class, newsVo.getId());
        
        news.setId(newsVo.getId());
        news.setTitle(newsVo.getTitle());
        news.setContent(newsVo.getContent());
        news.setNewsImgURL(newsVo.getNewsImgURL());
        
        newsDao.update(news);
    }

    @Override
    public void deleteNews(NewsVo newsVo) {
        
        logger.info("start...");
        
        News news = newsDao.get(News.class, newsVo.getId());
        newsDao.delete(news);
        
        logger.info("end...");
    }
}
