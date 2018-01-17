package com.lbj.demo.mapper;

import com.lbj.demo.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {

    @Select("SELECT u.id, u.name, u.password FROM lbj_ssm_p1.user u")
    List<User> queryList();

    @Select("SELECT u.id, u.name, u.password FROM lbj_ssm_p1.user u where u.id >= #{arg0} and u.id <= #{arg1}")
    List<User> queryListByNumber(Integer min,Integer max);

    @Select("SELECT u.id, u.name, u.password FROM lbj_ssm_p1.user u where u.id = #{id}")
    User singleUser(Integer id);

    @Insert("insert into lbj_ssm_p1.user(name, password) values(#{name}, #{password})")
    void save(User user);

    @Update("update lbj_ssm_p1.user set password = #{password} where id = #{id}")
    void update(User user);

    @Delete("delete from lbj_ssm_p1.user where id = #{id}")
    void delete(Integer id);
}
