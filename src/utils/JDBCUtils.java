package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

// 操作数据库工具类


public class JDBCUtils {
//    private static ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");
//
//    //c3p0
//
//    public static Connection getConnection2() throws SQLException {
//        Connection connection = cpds.getConnection();
//        return connection;
//    }


    //德鲁伊
    private static DataSource source1;
    static{
        try {
            Properties pros = new Properties();
            InputStream is =ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
            pros.load(is);
            source1 = DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection3() throws SQLException {

        Connection connection = source1.getConnection();
        return connection;
    }



    //关闭资源
    public static void closeResource1(Connection conn, Statement ps){
        try{
            if(ps != null)
                ps.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        try{
            if (conn != null)
                conn.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void closeResource1(Connection conn, Statement ps, ResultSet rs){
        try{
            if(ps != null)
                ps.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        try{
            if (conn != null)
                conn.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        try{
            if(rs != null)
                rs.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
