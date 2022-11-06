package dao.Impl;

import bean.User;
import dao.BeanDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.JDBCUtils;

import java.sql.Connection;
import java.util.List;


public class BeanDaoImpl implements BeanDao {
    @Override
    public void insert(Connection conn, User user) throws Exception {
        QueryRunner runner = new QueryRunner();
        String sql = "insert into info(number,name)values(?,?)";
        runner.update(conn,sql,user.getNumber(),user.getName());

    }

    @Override
    public void deleteByphone(Connection conn, String number) throws Exception {
        QueryRunner runner = new QueryRunner();
        String sql = "DELETE FROM info WHERE number = ?";
        runner.update(conn,sql,number);


    }

    @Override
    public void update(Connection conn, User user,String num) throws Exception {
        QueryRunner runner = new QueryRunner();
        String sql = "UPDATE info SET number=? ,`NAME`=? WHERE number = ?; ";
        runner.update(conn,sql,user.getNumber(),user.getName(),num);
    }

    @Override
    public List<User> getAll(Connection conn,int pageNum) throws Exception {
        QueryRunner runner = new QueryRunner();
        Connection connection = JDBCUtils.getConnection3();
        String sql = "select * from info LIMIT ?,4 ";
        BeanListHandler<User> handler = new BeanListHandler<>(User.class);
        List<User> list = runner.query(connection,sql,handler,pageNum);
        return list;
    }
}
