package ru.job4j.springapp.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("ru.job4j.springapp.dao")
@PropertySource("classpath:database.properties")
public class DataConfig {

    @Autowired
    Environment envoiriment;
//todo remange all the properties properly
    @Bean
    BasicDataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("jdbc.driverClassName");
        dataSource.setUsername("jdbc.username");
        dataSource.setPassword("jdbc.password");
        return dataSource;
    }

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
            factoryBean.setDataSource(dataSource());
            factoryBean.setPackagesToScan("ru.job4j.springapp.model");
            factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
            factoryBean.setJpaDialect(org.hibernate.dialect.MySQL5Dialect.class);
        return factoryBean;
    }

    @Bean
    JpaVendorAdapter jpaVendorAdapter() {
        JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        ((HibernateJpaVendorAdapter) jpaVendorAdapter).setShowSql(true);
        return jpaVendorAdapter;
    }


//    <bean id="entityManagerFactory" class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean">
//        <property name="dataSource" ref="dataSource"/>
//        <property name="packagesToScan" value="ru.job4j.springapp.model"/>
//        <property name="jpaVendorAdapter">
//            <bean class="org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter"/>
//        </property>
//        <property name="jpaProperties">
//            <props>
//                <prop key="hibernate.dialect">org.hibernate.dialect.MySQL5Dialect</prop>
//                <prop key="hibernate.show_sql">true</prop>
//            </props>
//        </property>
//    </bean>
//
//    <bean id="transactionManager"
//    class="org.springframework.orm.jpa.JpaTransactionManager">
//        <property name="entityManagerFactory" ref="entityManagerFactory"/>
//    </bean>
}
