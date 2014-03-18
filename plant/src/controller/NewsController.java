package controller;

import java.util.List;

import model.News;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.NewsService;
import VO.NewsVo;

@Controller("newsController")
@RequestMapping(value = "/news")
public class NewsController {

    @Autowired
    private NewsService newsService;
    
    public void saveNews(NewsVo newsVo){
        
        newsService.saveNews(newsVo);
    }
    
    public JSONObject getNews(NewsVo newsVo){
        
        JSONObject news = newsService.getNews(newsVo);
        
        return news;
    }
    
    public List<News> findNews(){
        
        List<News> newses = newsService.findNews();
        
        return newses;
    }
    
    public void updateNews(NewsVo newsVo){
        
        newsService.updateNews(newsVo);
    }
    
    public void deleteNews(NewsVo newsVo){
        
        newsService.deleteNews(newsVo);
    }
}
