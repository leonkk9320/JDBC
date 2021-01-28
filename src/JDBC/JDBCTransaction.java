package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
setAutoCommit(boolean autoCommit): 设置参数为false开启事务
commit(): 提交事务
rollback(): 回滚事务
 */
public class JDBCTransaction {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        try {
            //获取连接
            conn = Demo05JDBCUtils.getConnection();
            //开启事务
            conn.setAutoCommit(false);
            //定义sql
            String sql1 = "UPDATE money SET amount = amount - ? WHERE id = ?";
            String sql2 = "UPDATE money SET amount = amount + ? WHERE id = ?";
            //获取执行sql对象
            pstmt1 = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);
            //设置参数
            pstmt1.setDouble(1, 500);
            pstmt1.setDouble(2, 1);
            pstmt2.setDouble(1, 500);
            pstmt2.setDouble(2, 2);
            //执行
            pstmt1.executeUpdate();
            //手动制造异常
            int i = 3/0;
            pstmt2.executeUpdate();
            //事务提交
            conn.commit();

        } catch (Exception throwables) {
            //事务回滚（因为出现问题了，已作出的改变就不能提交）
            try {
                if(conn != null){
                    conn.rollback();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        }finally{
            Demo05JDBCUtils.close(pstmt1,conn);
            Demo05JDBCUtils.close(pstmt2,null);
        }
    }
}
