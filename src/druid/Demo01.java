package druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/*
Druid 演示
 */
public class Demo01 {
    public static void main(String[] args) throws Exception {
        //1.导入jar包：加入JDBC_libs并加载到library
        //2.定义配置文件：druid.properties
        //3.加载配置文件
        Properties pro = new Properties();
        InputStream is = Demo01.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);
        //4.获取连接"池"对象
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);

        //5.获取连接
        Connection conn = ds.getConnection();
        System.out.println(conn);

    }
}
