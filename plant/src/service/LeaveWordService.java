package service;

import java.util.List;

import model.LeaveWord;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import VO.LeaveWordVo;

public interface LeaveWordService {

    /**
     * Save the LeaveWord model
     * @param leaveWordVo
     */
    void saveLeaveWord(LeaveWordVo leaveWordVo);

    /**
     * Get a LeaveWord entity
     * @param leaveWordVo
     * @return
     */
    JSONObject getLeaveWord(LeaveWordVo leaveWordVo);

    /**
     * Find all except the expired records from database 
     * @return
     */
    List<LeaveWord> findLeaveWords();

    /**
     * Delete a LeaveWord entity
     * @param leaveWordVo
     */
    void deleteLeaveWord(LeaveWordVo leaveWordVo);

}
