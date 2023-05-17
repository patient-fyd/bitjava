package com.example.springmvcdemo.controller;

import com.example.springmvcdemo.model.Student;
import com.example.springmvcdemo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * @Author: Fourteen-Y
 * @Description:
 * @Date: 2023/5/4 9:10
 */
@Controller
@ResponseBody   // 当前类返回的是非静态页面
@RequestMapping("/web")
public class WebController {

    //@RequestMapping(value = "/hi",method = RequestMethod.GET)
    @GetMapping("/hi")
    //@PostMapping("/hi")
    public Object sayHi(HttpServletRequest request, HttpServletResponse response){
        return "hi," + request.getParameter("name");
    }

    /**
     * 获取单个参数
     * @return
     */
    @GetMapping("/get1")
    public String getParam1(String name){
        return "value:  " + name;
    }

    /**
     * 获取多个参数
     * @param name
     * @param age
     * @return
     */
    @GetMapping("/get2")
    public String getParam2(String name,Integer age){
        return "name:" + name + " age: " + age;
    }

    /**
     * 获取对象参数
     * @param student
     * @return
     */
    @GetMapping("/get3")
    public String getParam3(Student student){
        return student.toString();
    }

    /**
     * 获取form表单中的参数
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public String login(String username,String password){
        return "<h1>用户名" + username + "密码" + password + "</h1>";
    }

    /**
     * 获取form表单中的参数
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login2")
    public HashMap<String, Object> login2(String username, String password){
        HashMap<String, Object> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        return map;
    }

    @RequestMapping("/login3")
    public HashMap<String, Object> login3(@RequestBody User user){
        HashMap<String, Object> map = new HashMap<>();
        map.put("username",user.getUsername());
        map.put("password",user.getPassword());
        return map;
    }

    /**
     * 获取form表单（多个参数）
     * @param user
     * @return
     */
    @RequestMapping("/reg")
    public String reg(User user){
        return user.toString();
    }

}
