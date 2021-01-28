package JDBC;

import java.sql.*;

public class Demo04ResultSet {
    public static void main(String[] args) {
        ResultSet rs = null;
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
            String sql = "SELECT * FROM orders ";

            //5.执行
            rs = stmt.executeQuery(sql);


            //6.处理结果
            //游标移到下一行
            while(rs.next()){
                //两种获取列的方式
                int id = rs.getInt(1);//列序号，从1开始
                String comments = rs.getString("comments");//列名
                System.out.println(id + " ==> " + comments);
            }



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
