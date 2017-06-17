/**
 * @ClassName:     UserController.java
 * @Description:   TODO 
 * @author         Administrator
 * @Date           2017年6月17日 下午5:22:28 
 */
package com.xc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xc.entity.User;
import com.xc.service.UserService;

/**
 * @ClassName:     UserController
 * @Description:TODO
 * @author:    Android_Robot
 * @date:        2017年6月17日 下午5:22:28
 *
 */
@Controller
public class UserController {
	@Resource(name="userService")// 获取spring配置文件中bean的id为userManager的，并注入   
    private UserService userService;  
      
    @RequestMapping("/toAddUser")  
    public String toAddUser(){  
        return "/addUser";  
    }  
      
    @RequestMapping("/addUser")// 请求url地址映射，类似Struts的action-mapping   
    public String addUser(User user){  
          
    	userService.addUser(user);  
          
        return "redirect:/user/getAllUser";  
    }  
      
    @RequestMapping("/getAllUser")  
    public String getAllUser(HttpServletRequest request){  
        List<User> user = userService.getAllUser();  
          
        request.setAttribute("user", user);  
          
        return "/userManager";  
    }  
      
    @RequestMapping("/delUser")  
    public void delUser(String id,HttpServletResponse response){  
        String result = "{\"result\":\"error\"}";  
        if(userService.delUser(id)){  
            result = "{\"result\":\"success\"}";  
        }  
        PrintWriter out = null;  
        response.setContentType("application/json");  
          
        try {  
            out = response.getWriter();  
            out.write(result);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
          
    }  
      
    @RequestMapping("/getUser")  
    public String getUser(String id,HttpServletRequest request){  
        User user = userService.getUser(id);  
          
        request.setAttribute("user", user);  
        return "/editUser";  
    }  
      
    @RequestMapping("/updateUser")  
    public String updateUser(User user,HttpServletRequest request){  
          
        if(userService.updateUser(user)){  
            user = userService.getUser(user.getId());  
            request.setAttribute("user", user);  
            return "/editUser";  
        }else{  
            return "/error";  
        }  
          
    }  
}
