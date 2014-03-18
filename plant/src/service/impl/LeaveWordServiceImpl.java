package service.impl;

import java.util.List;

import model.LeaveWord;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import service.LeaveWordService;
import VO.LeaveWordVo;
import dao.LeaveWordDao;

@Repository("leaveWordService")
public class LeaveWordServiceImpl implements LeaveWordService{
    
    private Logger logger = Logger.getLogger(LeaveWordServiceImpl.class);
    
    @Autowired
    private LeaveWordDao leaveWordDao;

    /* (non-Javadoc)
     * @see service.LeaveWordService#saveLeaveWord(VO.LeaveWordVo)
     */
    @Override
    public void saveLeaveWord(LeaveWordVo leaveWordVo) {
        
        logger.info("start...");
        
        LeaveWord leaveWord = new LeaveWord();
        
        leaveWord.setTitle(leaveWordVo.getTitle());
        leaveWord.setName(leaveWordVo.getName());
        leaveWord.setTelephone(leaveWordVo.getTelephone());
        leaveWord.setEmail(leaveWordVo.getEmail());
        leaveWord.setQq(leaveWordVo.getQq());
        leaveWord.setContent(leaveWordVo.getContent());
        
        leaveWordDao.save(leaveWord);
        
        logger.info("end...");
    }

    /* (non-Javadoc)
     * @see service.LeaveWordService#getLeaveWord(VO.LeaveWordVo)
     */
    @Override
    public JSONObject getLeaveWord(LeaveWordVo leaveWordVo) {
        
        logger.info("start...");
        
        LeaveWord leaveWord = leaveWordDao.get(LeaveWord.class, leaveWordVo.getId());
        
        JSONObject object = new JSONObject();
        
        object.put("leaveWordId", leaveWord.getId());
        object.put("title", leaveWord.getTitle());
        object.put("name", leaveWord.getName());
        object.put("telephone", leaveWord.getTelephone());
        object.put("email", leaveWord.getEmail());
        object.put("qq", leaveWord.getQq());
        object.put("content", leaveWord.getContent());
        
        logger.info("end...");
        
        return object;
    }

    /* (non-Javadoc)
     * @see service.LeaveWordService#findLeaveWords()
     */
    @Override
    public List<LeaveWord> findLeaveWords() {
        
        logger.info("start...");
        
        List<LeaveWord> leaveWords = leaveWordDao.findAll(LeaveWord.class);
        
        logger.info("end...");
        
        return leaveWords;
    }

    @Override
    public void deleteLeaveWord(LeaveWordVo leaveWordVo) {
        
        logger.info("start...");
        
        LeaveWord leaveWord = leaveWordDao.get(LeaveWord.class, leaveWordVo.getId());
        leaveWordDao.delete(leaveWord);
        
        logger.info("end...");
    }
    
    

    
}
