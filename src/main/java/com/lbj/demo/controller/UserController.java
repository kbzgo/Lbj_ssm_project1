package com.lbj.demo.controller;

import com.lbj.demo.Service.UserService;
import com.lbj.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /***
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/getUser")
    public List<User> getUser(){

        return userService.queryList();
    }

    /***
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/getByNumber")
    public List<User> getByNumber(Integer min,Integer max){
        System.out.println("min = "+min);
        System.out.println("max = "+max);
        return userService.queryListByNumber(min,max);
    }

    /***
     *
     * @param receiveid
     * @return
     */
    @ResponseBody   //自动返回Json类型
    @RequestMapping("/getUserById")
    public User getUserById(Integer receiveid){
        System.out.print(receiveid);
        return userService.queryListById(receiveid);
    }

    /***
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/addUser")
    public String addUser(@RequestBody User u){
        return userService.save(u);
    }

    /***
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteUser")
    public String deleteUser(Integer id){
        return userService.delete(id);
    }

    @ResponseBody
    @RequestMapping("/updateUser")
    public String updateUser(@RequestBody User u){              //post方法有效，get方法无效
        return userService.update(u);
    }
}
