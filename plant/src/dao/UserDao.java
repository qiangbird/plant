package dao;

import model.User;

public interface UserDao extends BaseDao<User>{

    User checkLoginUser(String name, String password);
    
}
