package service;

import java.util.List;

import model.News;
import net.sf.json.JSONObject;
import VO.NewsVo;

public interface NewsService {

    /**
     * Save the News model
     * @param newsVo
     */
    void saveNews(NewsVo newsVo);

    /**
     * Get a news entity
     * @param newsVo
     * @return
     */
    JSONObject getNews(NewsVo newsVo);

    /**
     * Find all news except the expired record
     * @return
     */
    List<News> findNews();

    /**
     * Update the news entity
     * @param newsVo
     */
    void updateNews(NewsVo newsVo);

    /**
     * Delete a News entity
     * @param newsVo
     */
    void deleteNews(NewsVo newsVo);

}
