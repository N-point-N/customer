package configure;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JdbcConfigurer {

    @Bean
    public DataSource jdbcDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://104.248.209.126:3306/web_customer_tracker");
        dataSource.setUsername("webstudent");
        dataSource.setPassword("webstudent");
        dataSource.setMaxIdle(20);
        dataSource.setMinIdle(5);
        dataSource.setMaxOpenPreparedStatements(20);


        return dataSource;
    }
}
