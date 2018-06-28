package xin.wangjue.dao;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import xin.wangjue.domain.entity.SysUser;

import java.util.List;

@Component
public interface SysUserDao {
    @Select("select * from sys_user")
    @Results({
            @Result(property = "userID" ,column = "USER_ID"),
            @Result(property = "userName" ,column = "USER_NAME"),
            @Result(property = "passWord" ,column = "PASSWORD"),
            @Result(property = "cn" ,column = "CN"),
            @Result(property = "phoneNumber" ,column = "PHONE_NUMBER")
    })
    List<SysUser> listSysUser();

    @Select("select * from sys_user where user_id = #{userId}")
    @Results({
            @Result(property = "userID" ,column = "USER_ID"),
            @Result(property = "userName" ,column = "USER_NAME"),
            @Result(property = "passWord" ,column = "PASSWORD"),
            @Result(property = "cn" ,column = "CN"),
            @Result(property = "phoneNumber" ,column = "PHONE_NUMBER")
    })
    SysUser findSysUserById(long userId);
}
