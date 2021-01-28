package SpringJDBC;

import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;
/*
使用SpringJDBC之后，只关心sql语句与参数，不用释放资源
当然我们需要DataSource对象
 */
public class Demo01JdbcTemplate {
    public static void main(String[] args) {
        //导入jar包，5个
        //创建JdbcTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        //调用方法
        String sql = "UPDATE money SET amount = 7000 WHERE id = ?";
        int count = template.update(sql, 3);
        System.out.println(count);

    }
}
