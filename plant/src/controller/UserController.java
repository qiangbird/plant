package controller;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import service.UserService;
import VO.UserVo;

@Controller("userController")
@RequestMapping(value = "/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    public ModelAndView checkLoginUser(UserVo userVo){
        
        ModelAndView modelAndView = new ModelAndView();
        boolean isLegalUser = userService.checkLoginUser(userVo);
        
        if(Boolean.TRUE == isLegalUser){
            modelAndView.setViewName("home");
        }else{
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }
    
    public void saveUser(UserVo userVo){
        
        userService.saveUser(userVo);
    }
    
    public void updateUser(UserVo  userVo){
        
        userService.updateUser(userVo);
    }
    
    @ResponseBody
    public JSONObject getUserById(UserVo userVo){
        
        JSONObject user = userService.getUserById(userVo);
        
        return user;
    }
    
    public void deleteUser(UserVo userVo){
        
        userService.deleteUser(userVo);
    }
}
