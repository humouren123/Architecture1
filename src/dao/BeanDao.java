package dao;


import bean.User;

import java.sql.Connection;
import java.util.List;

public interface BeanDao {
    void insert(Connection conn, User user )throws Exception;

    void deleteByphone(Connection conn,String number)throws Exception;

    void update(Connection conn,User user,String num) throws Exception;

    List<User> getAll(Connection conn,int PageNum) throws Exception;
}
