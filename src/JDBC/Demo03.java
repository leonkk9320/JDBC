package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
修改记录
使用Java7新特性
 */
public class Demo03 {
    public static void main(String[] args) {
        try(
                //2.获取连接对象
                Connection connection =
                    DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sql_store", "root", "Waagl2411");
                //4.获取执行sql对象
                Statement stmt = connection.createStatement();)
        {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            //3.sql语句
            String sql = "UPDATE orders SET comments = 'java newly added' WHERE order_id = 12";

            //5.执行
            int count = stmt.executeUpdate(sql);
            System.out.println(count);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
