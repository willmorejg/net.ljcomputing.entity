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

package net.ljcomputing.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import net.ljcomputing.domain.Person;

/**
 * MyBatis Person Mapper
 * 
 * @author James G. Willmore
 *
 */
@Mapper
public interface PersonMapper extends MyBatisMapper<Person, Integer> {

  /**
   * @see net.ljcomputing.mapper.MyBatisMapper#create(net.ljcomputing.entity.PersistedEntity)
   */
  @Insert({
      "insert into people (uuid, name, created_ts, modified_ts) values (#{uuid,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, #{createdTs,jdbcType=BIGINT}, #{modifiedTs,jdbcType=BIGINT})" })
  @SelectKey(statement = "select max(id) as id from people", keyProperty = "id", keyColumn = "id", before = false, resultType = Integer.class)
  Integer create(Person entity);

  /**
   * @see net.ljcomputing.mapper.MyBatisMapper#readAll()
   */
  @Select({ "select id, uuid, name, created_ts, modified_ts from people" })
  List<Person> readAll();

  /**
   * Read by id.
   *
   * @param id the id
   * @return the person
   * @see net.ljcomputing.mapper.MyBatisMapper#readById(java.io.Serializable)
   */
  @Select({
      "select id, uuid, name, created_ts, modified_ts from people where id = #{id,jdbcType=INTEGER}" })
  Person readById(Integer id);

  /**
   * @see net.ljcomputing.mapper.MyBatisMapper#update(net.ljcomputing.entity.PersistedEntity)
   */
  @Update({
      "update people set name = #{name,jdbcType=VARCHAR}, modified_ts = #{modifiedTs,jdbcType=BIGINT} where id = #{id,jdbcType=INTEGER}" })
  void update(Person entity);

  /**
   * @see net.ljcomputing.mapper.MyBatisMapper#delete(net.ljcomputing.entity.PersistedEntity)
   */
  void delete(Person entity);

  /**
   * @see net.ljcomputing.mapper.MyBatisMapper#delete(java.io.Serializable)
   */
  @Delete({ "delete from people where id = #{id,jdbcType=INTEGER}" })
  void delete(Integer id);
}
