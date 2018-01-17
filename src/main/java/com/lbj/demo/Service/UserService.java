package com.lbj.demo.Service;

import com.lbj.demo.mapper.UserMapper;
import com.lbj.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> queryList() {
        List<User> list = new ArrayList<User>();
        list = userMapper.queryList();
        return list;
    }

    public List<User> queryListByNumber(Integer min,Integer max) {
        List<User> list = new ArrayList<User>();
        list = userMapper.queryListByNumber(min,max);
        return list;
    }

    public User queryListById(Integer id) {
        return userMapper.singleUser(id);
    }

    public String save(User user) {
        userMapper.save(user);
        return user.toString();
    }

    public String delete(Integer id) {
        userMapper.delete(id);
        return "Success!";
    }

    public String update(User user) {
        userMapper.update(user);
        return "Success";
    }
}
