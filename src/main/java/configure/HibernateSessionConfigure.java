package configure;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
public class HibernateSessionConfigure {


    @Bean
    public ComboPooledDataSource hibernateDataSource() {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        try {
            comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://104.248.209.126:3306/web_customer_tracker");
        comboPooledDataSource.setUser("webstudent");
        comboPooledDataSource.setPassword("webstudent");
        comboPooledDataSource.setMaxPoolSize(20);
        comboPooledDataSource.setMinPoolSize(5);
        comboPooledDataSource.setMaxIdleTime(30000);

        return comboPooledDataSource;
    }


    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean sessionFactoryBean() {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(hibernateDataSource());

        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        hibernateProperties.setProperty("show_sql", "true");
        localSessionFactoryBean.setHibernateProperties(hibernateProperties);

        return localSessionFactoryBean;
    }

    @Bean(name = "myTransactionManager")
    public HibernateTransactionManager transactionManagerBean() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactoryBean().getObject());
        return transactionManager;
    }


}
