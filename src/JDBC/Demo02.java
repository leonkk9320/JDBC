package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
insert
 */
public class Demo02 {
    public static void main(String[] args) {
        Statement stmt = null;
        Connection connection = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.定义sql
            String sql = "insert into orders values(null, 1, '2021-01-15', 1, 'newly added', null, null)";
            //3.获取Connection对象
            connection = DriverManager.getConnection("jdbc:mysql:///sql_store", "root", "Waagl2411");
            //4.获取执行sql的对象Statement
            stmt = connection.createStatement();
            //5.执行sql
            int count = stmt.executeUpdate(sql);
            //6.处理结果
            System.out.println(count);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            //7.释放资源
            //避免空指针异常
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(connection != null){
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
