/**
 * @ClassName:     UserServiceImpl.java
 * @Description:   TODO 
 * @author         Administrator
 * @Date           2017年6月17日 下午5:24:10 
 */
package com.xc.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xc.dao.UserDao;
import com.xc.entity.User;
import com.xc.service.UserService;

/**
 * @ClassName:     UserServiceImpl
 * @Description:TODO
 * @author:    Android_Robot
 * @date:        2017年6月17日 下午5:24:10
 *
 */

@Service
public class UserServiceImpl implements UserService{
	 
	private UserDao userDao;  
    
    
    public void setUserDao(UserDao userDao) {  
        this.userDao = userDao;  
    }  
  
  
    @Override  
    public void addUser(User user) {  
        userDao.addUser(user);  
    }  
  
  
    @Override  
    public List<User> getAllUser() {  
        return userDao.getAllUser();  
    }  
  
  
    @Override  
    public boolean delUser(String id) {  
        return userDao.delUser(id);  
    }  
  
  
    @Override  
    public User getUser(String id) {  
        return userDao.getUser(id);  
    }  
  
  
    @Override  
    public boolean updateUser(User user) {  
        return userDao.updateUser(user);  
    }  
}
