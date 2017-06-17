/**
 * @ClassName:     UserService.java
 * @Description:   TODO 
 * @author         Administrator
 * @Date           2017年6月17日 下午5:24:22 
 */
package com.xc.service;

import java.util.List;

import com.xc.entity.User;

/**
 * @ClassName:     UserService
 * @Description:TODO
 * @author:    Android_Robot
 * @date:        2017年6月17日 下午5:24:22
 *
 */
public interface UserService {
	
	public void addUser(User user);  
    
    public List<User> getAllUser();  
      
    public boolean delUser(String id);  
      
    public User getUser(String id);  
      
    public boolean updateUser(User user);  
}
