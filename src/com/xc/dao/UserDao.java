/**
 * @ClassName:     UserDao.java
 * @Description:   TODO 
 * @author         Administrator
 * @Date           2017年6月17日 下午5:20:30 
 */
package com.xc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.xc.entity.User;

/**
 * @ClassName:     UserDao
 * @Description:TODO
 * @author:    Android_Robot
 * @date:        2017年6月17日 下午5:20:30
 *
 */
public class UserDao {
	@Autowired
	private SessionFactory sessionFactory;  
    
    public void setSessionFactory(SessionFactory sessionFactory) {  
        this.sessionFactory = sessionFactory;  
    }  
  
  
    public void addUser(User user) {//添加用户  
        sessionFactory.getCurrentSession().save(user);  
    }  
  
    
        public List<User> getAllUser() {//查找所有用户信息  
        String hql = "from User";  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
          
        return query.list();  
    }  
  
      
    public boolean delUser(String id) {//删除用户  
        String hql = "delete User u where u.id=?";  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        query.setString(0, id);  
          
        return (query.executeUpdate() > 0);  
    }  
  
      
    public User getUser(String id) {//根据id得到单个用户  
        String hql = "from User u where u.id=?";  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);//此时使用的是hql语句  
        query.setString(0, id);  
          
        return (User) query.uniqueResult();  
    }  
  
    
    public boolean updateUser(User user) {//修改用户信息,hql语句  
        String hql = "update User u set u.userName=?,u.age=? where u.id=?";  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        query.setString(0, user.getUserName());  
        query.setString(1, user.getAge());  
        query.setString(2, user.getId());  
          
        return (query.executeUpdate() > 0);  
    }  
}
