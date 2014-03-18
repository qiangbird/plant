package service.impl;

import model.User;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import service.UserService;
import VO.UserVo;
import dao.UserDao;

@Repository("userService")
public class UserServiceImpl implements UserService{

    private Logger logger = Logger.getLogger(UserServiceImpl.class);
    
    @Autowired
    private UserDao userDao;
    
    @Override
    public boolean checkLoginUser(UserVo userVo) {
        
        logger.info("start...");
        
        User user = userDao.checkLoginUser(userVo.getName(), userVo.getPassword());
        
        // user exist in the database
        if(null != user){
            return true;
        }
        logger.info("end...");
        return false;
    }

    @Override
    public void saveUser(UserVo userVo) {
        
        logger.info("start...");
        
        User user =  new User();
        
        user.setName(userVo.getName());
        user.setPassword(userVo.getPassword());
        user.setEmail(userVo.getEmail());
        
        userDao.save(user);
        
        logger.info("end...");
    }

    @Override
    public void updateUser(UserVo userVo) {
        
        logger.info("start...");
        
        User user =  userDao.get(User.class, userVo.getId());
        
        user.setName(userVo.getName());
        user.setPassword(userVo.getPassword());
        user.setEmail(userVo.getEmail());
        
        userDao.update(user);
        
        logger.info("end...");
    }

    @Override
    public JSONObject getUserById(UserVo userVo) {
        
        logger.info("start...");
        
        User user = userDao.get(User.class, userVo.getId());
        
        JSONObject object = new JSONObject();
        
        object.put("userId", user.getId());
        object.put("userName", user.getName());
        object.put("password", user.getPassword());
        object.put("email", user.getEmail());
        
        logger.info("end...");
        
        return object;
    }

    @Override
    public void deleteUser(UserVo userVo) {
        
        logger.info("start...");
        //TODO check the user whether is the system admin(John)
        // if is John, than can't delete it.
        User user = userDao.get(User.class, userVo.getId());
        userDao.delete(user);
        
        logger.info("end...");
    }

}
