package org.xgrt.mapper;

import org.xgrt.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    /**
     * 根据用户名和密码查询用户对象
     *
     * @return
     */
    @Select("Select * from tb_user where username=#{userName} and password=#{password}")
    User select(@Param("userName") String userName, @Param("password") String password);

    /**
     * 根据用户名查询用户对象
     *
     * @param userName
     * @return
     */
    @Select("SELECT * from tb_user where userName= #{userName}")
    User selectByUserName(String userName);

    /**
     * 添加用户
     *
     * @param user
     */
    @Insert("insert into tb_user values (null,#{userName},#{password})")
    void add(User user);
}
