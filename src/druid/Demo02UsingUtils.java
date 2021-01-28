package druid;

import utils.JDBCUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
使用工具类
 */
public class Demo02UsingUtils {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "INSERT INTO money VALUES (null, ?, ?) ";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,"leon");
            pstmt.setInt(2,5000);

            int i = pstmt.executeUpdate();
            System.out.println(i);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally{
            JDBCUtils.close(pstmt, conn);
        }
    }
}
