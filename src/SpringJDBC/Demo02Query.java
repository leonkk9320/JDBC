package SpringJDBC;

import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;//数据到javaBean的自动封装
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class Demo02Query {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Test
    public void test1(){
        String sql = "SELECT * FROM money";
        List<Money> list = template.query(sql, new BeanPropertyRowMapper<Money>(Money.class));

        for(Money m : list){
            System.out.println(m);
        }
    }

    @Test
    public void test2(){
        String sql = "SELECT count(id) FROM money";
        Long total = template.queryForObject(sql, long.class);//聚合函数
        System.out.println(total);
    }
}
