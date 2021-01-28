package JDBC;

import java.sql.*;
import java.util.Scanner;

/*
登陆练习：用户密码登陆

SQL 注入问题：拼接sql时候，有一些sql特殊关键字会参与字符串的拼接，会造成安全问题。
解决：使用preparedStatement。
预编译：参数使用？作为占位符

PreparesStatement: 防止sql注入+效率更高， 以后不用Statement对象
 */
public class JDBC06login {

    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名： ");
        String username = sc.nextLine();
        System.out.println("请输入密码： ");
        String password = sc.nextLine();
        //判断
        boolean flag = new JDBC06login().login(username, password);
        //结果打印
        if(flag){
            System.out.println("登陆成功！");
        }else{
            System.out.println("用户名活密码错误！");
        }
    }

    public boolean login(String username, String password){
        if(username == null && password == null){
            return false;
        }

        //连接数据库判断是否登陆成功
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = Demo05JDBCUtils.getConnection();

//            String sql = "SELECT * FROM users WHERE username = '" + username + "' AND password = '"+ password +"'";
//            stmt = conn.createStatement();
//            rs = stmt.executeQuery(sql);
//            return rs.next();

            //定义sql
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            //获取执行sql的对象
            pstmt = conn.prepareStatement(sql);
            //给？赋值
            pstmt.setString(1, username);//从1开始
            pstmt.setString(2, password);
            //执行，不需要传递sql
            rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            Demo05JDBCUtils.close(pstmt, conn, rs);
        }

        return false;
    }
}
