package dao.impl;

import java.util.ArrayList;
import java.util.List;

import model.User;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import dao.UserDao;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Override
    public User checkLoginUser(String name, String password) {
        
        List<User> users = new ArrayList<User>();
        DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
        
        criteria.add(Restrictions.eq("name", name));
        criteria.add(Restrictions.eq("password", password));
        
        users = findByCriteria(criteria);
        
        return users.get(0);
    }
    
    
}
