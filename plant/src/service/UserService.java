package service;

import net.sf.json.JSONObject;
import VO.UserVo;

public interface UserService {

    /**
     * Check the login user whether is legal user
     * @author John.Li
     * @param userVo
     * @return
     */
    boolean checkLoginUser(UserVo userVo);

    /**
     * Save user into the database
     * @param userVo
     */
    void saveUser(UserVo userVo);

    /**
     * Update the user
     * @param userVo
     */
    void updateUser(UserVo userVo);

    /**
     * Get user by id
     * @param userVo
     */
    JSONObject getUserById(UserVo userVo);

    /**
     * Delete the user
     * @param userVo
     */
    void deleteUser(UserVo userVo);

}
