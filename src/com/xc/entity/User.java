/**
 * @ClassName:     User.java
 * @Description:   TODO 
 * @author         Administrator
 * @Date           2017年6月17日 下午5:36:27 
 */
package com.xc.entity;

import javax.persistence.Column;

/**
 * @ClassName:     User
 * @Description:TODO
 * @author:    Android_Robot
 * @date:        2017年6月17日 下午5:36:27
 *
 */
public class User {
	
	private String id;  
    
    @Column(length=32)  
    private String userName;  
      
    @Column(length=32)  
    private String age;  
  
    public String getUserName() {  
        return userName;  
    }  
  
    public void setUserName(String userName) {  
        this.userName = userName;  
    }  
  
    public String getAge() {  
        return age;  
    }  
  
    public void setAge(String age) {  
        this.age = age;  
    }  
      
    public String getId() {  
        return id;  
    }  
  
    public void setId(String id) {  
        this.id = id;  
    }  
}
