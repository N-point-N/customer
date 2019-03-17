package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class MainDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(@Qualifier("jdbcDataSource") DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void getCheTo(){
        Integer count = jdbcTemplate.queryForObject("select COUNT(*) from customer", Integer.class);
        System.out.println(count);
    }
}
