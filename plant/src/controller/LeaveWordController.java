package controller;

import java.util.List;

import model.LeaveWord;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.LeaveWordService;
import VO.LeaveWordVo;

@Controller("leaveWordController")
@RequestMapping(value = "/leaveWord")
public class LeaveWordController {

    @Autowired
    private LeaveWordService leaveWordService;
    
    public void saveLeaveWord(LeaveWordVo leaveWordVo){
        
        leaveWordService.saveLeaveWord(leaveWordVo);
    }
    
    @ResponseBody
    public JSONObject getLeaveWord(LeaveWordVo leaveWordVo){
        
        JSONObject leaveWord = leaveWordService.getLeaveWord(leaveWordVo);
        
        return leaveWord;
    }
    
    @ResponseBody
    public List<LeaveWord> findLeaveWords(){
        
        List<LeaveWord> leaveWords =  leaveWordService.findLeaveWords();
        
        return leaveWords;
    }
    
    public void deletLeaveWord(LeaveWordVo leaveWordVo){
        
        leaveWordService.deleteLeaveWord(leaveWordVo);
    }
}
