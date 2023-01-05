package org.xgrt.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.xgrt.mapper.UserMapper;
import org.xgrt.pojo.User;
import org.xgrt.util.SqlSessionFactoryUtils;

public class UserService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 登录方法
     *
     * @param userName
     * @param password
     * @return
     */
    public User login(String userName, String password) {
        //获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        User user = mapper.select(userName, password);
        //释放资源
        sqlSession.close();

        return user;
    }

    /**
     * 注册方法
     *
     * @param user
     * @return
     */
    public boolean register(User user) {
        //获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //判断用户是否存在
        User checkedUser = mapper.selectByUserName(user.getUserName());
        if (checkedUser == null) {
            //用户名不存在
            mapper.add(user);
            sqlSession.commit();
        }
        //释放资源
        sqlSession.close();

        return checkedUser == null;
    }
}
