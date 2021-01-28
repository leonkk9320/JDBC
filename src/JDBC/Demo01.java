package JDBC;

/*
各个对象：
    1.DriverManager: 驱动管理对象
        功能：注册驱动 + 获取数据库连接
    2.Connection: 数据库连接对象
        a.获取sql 执行对象 Statement 与 PreparedStatement
        b.管理事务 开启、提交、回滚
    3.Statement: 执行sql的对象，可以有 int stmt.executeUpdate() 与 ResultSet stmt.executeQuery()
    4.ResultSet: 结果集对象 查询出来的结果
    5.PreparedStatement: 执行sql的对象 Statement子类

 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo01 {
    public static void main(String[] args) throws Exception {
        //1.导入驱动jar 包
        //2.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver"); //家在类，执行静态代码块
        //3.获取数据库连接对象
        Connection conn =
                DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/sql_store", "root", "Waagl2411");
        //4.定义sql 语句
        String sql = "update orders set comments = 'java' where order_id = 1";
        //5.获取执行sql的对象Statement
        Statement stmt = conn.createStatement();
        //6.执行sql
        int count = stmt.executeUpdate(sql);
        //7.处理结果
        System.out.println(count);
        //8.释放资源
        stmt.close();
        conn.close();

    }


}
