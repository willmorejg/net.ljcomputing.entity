/**
           Copyright 2016, James G. Willmore

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package net.ljcomputing.config;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Persistence configuration.
 * 
 * @author James G. Willmore
 *
 */
@Configuration
@ComponentScan(basePackages = { "net.ljcomputing" })
@PropertySource("classpath:datasource.properties")
@EnableAspectJAutoProxy
@MapperScan("net.ljcomputing.mapper")
@EnableTransactionManagement
public class PersistenceConfiguration {

  /** The SLF4J Logger. */
  @SuppressWarnings("unused")
  private static final Logger LOGGER = LoggerFactory.getLogger(PersistenceConfiguration.class);

  /** The driver class. */
  @Value("${dataSource.driver.class}")
  private String driverClassname;

  /** The url. */
  @Value("${dataSource.url}")
  private String url;

  /** The username. */
  @Value("${dataSource.username}")
  private String username;

  /** The password. */
  @Value("${dataSource.password}")
  private String password;

  /**
   * Data source.
   *
   * @return the data source
   */
  @Bean
  public DataSource dataSource() {
    final SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

    try {
      final Driver driverClass = DriverManager.getDriver(url);

      dataSource.setDriverClass(driverClass.getClass());
      dataSource.setUrl(url);
      dataSource.setUsername(username);
      dataSource.setPassword(password);
    } catch (SQLException exception) {
      exception.printStackTrace();
    }

    return dataSource;
  }

  /**
   * Transaction manager.
   *
   * @return the data source transaction manager
   */
  @Bean
  public DataSourceTransactionManager transactionManager() {
    return new DataSourceTransactionManager(dataSource());
  }

  /**
   * Sql session factory.
   *
   * @return the sql session factory bean
   * @throws Exception the exception
   */
  @Bean
  public SqlSessionFactory sqlSessionFactory() throws Exception {
    final org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
    configuration.setMapUnderscoreToCamelCase(true);

    final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();

    sessionFactory.setDataSource(dataSource());
    sessionFactory.setConfiguration(configuration);
    sessionFactory.setTypeAliasesPackage("net.ljcomputing.repository.entity");

    final SqlSessionFactory factory = sessionFactory.getObject();

    return factory;
  }
}
