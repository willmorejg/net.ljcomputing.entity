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

package net.ljcomputing.test;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.ljcomputing.config.PersistenceConfiguration;
import net.ljcomputing.domain.Person;
import net.ljcomputing.mapper.PersonMapper;

/**
 * @author James G. Willmore
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@Import(PersistenceConfiguration.class)
public class PersonMapperTest {

  /** The SLF4J Logger. */
  @SuppressWarnings("unused")
  private static final Logger LOGGER = LoggerFactory.getLogger(PersonMapperTest.class);

  @Autowired
  private DataSource dataSource;

  @Autowired
  private PersonMapper personMapper;
  
  private static void createTable(final Connection conn) throws SQLException {
    final Statement stmt = conn.createStatement();
    stmt.executeUpdate("create table people (id integer not null generated always as identity (START WITH 1, INCREMENT BY 1), uuid varchar(64), name varchar(255), created_ts bigint, modified_ts bigint, CONSTRAINT people_pk PRIMARY KEY (id))");
    stmt.close();
  }

  private boolean validateDataSource() {
    boolean result = false;
    Connection connection = null;
    
    try {
      connection = dataSource.getConnection();
      createTable(connection);
    } catch (SQLException exception) {
      LOGGER.error("Exception occured while validating data source: ", exception);
    } finally {
      if(connection != null) {
        try {
          connection.close();
        } catch (SQLException e) {
          //ignore
        }
      }
    }

    return result;
  }

  @Test
  public void test() {
    assertNotNull("Person Mapper is null", personMapper);
    validateDataSource();

    List<Person> people = personMapper.readAll();
    LOGGER.debug("people: {}", people);
    
    final Person person = new Person();
    person.setName("jim");
    
    LOGGER.debug("creating person: {}", person);
    personMapper.create(person);
    
    for(Person p : personMapper.readAll()) {
      LOGGER.debug("-- person {}", p);
    }
  }
  //
  //  /**
  //   * Test method for {@link net.ljcomputing.mapper.PersonMapper#create(net.ljcomputing.domain.Person)}.
  //   */
  //  @Test
  //  public void testCreatePerson() {
  //    fail("Not yet implemented");
  //  }
  //
  //  /**
  //   * Test method for {@link net.ljcomputing.mapper.PersonMapper#readAll()}.
  //   */
  //  @Test
  //  public void testReadAll() {
  //    fail("Not yet implemented");
  //  }
  //
  //  /**
  //   * Test method for {@link net.ljcomputing.mapper.PersonMapper#readById(java.lang.String)}.
  //   */
  //  @Test
  //  public void testReadByIdString() {
  //    fail("Not yet implemented");
  //  }
  //
  //  /**
  //   * Test method for {@link net.ljcomputing.mapper.PersonMapper#update(net.ljcomputing.domain.Person)}.
  //   */
  //  @Test
  //  public void testUpdatePerson() {
  //    fail("Not yet implemented");
  //  }
  //
  //  /**
  //   * Test method for {@link net.ljcomputing.mapper.PersonMapper#delete(net.ljcomputing.domain.Person)}.
  //   */
  //  @Test
  //  public void testDeletePerson() {
  //    fail("Not yet implemented");
  //  }
  //
  //  /**
  //   * Test method for {@link net.ljcomputing.mapper.PersonMapper#delete(java.lang.String)}.
  //   */
  //  @Test
  //  public void testDeleteString() {
  //    fail("Not yet implemented");
  //  }

}
