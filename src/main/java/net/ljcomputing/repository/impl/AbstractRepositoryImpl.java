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

package net.ljcomputing.repository.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import net.ljcomputing.entity.PersistedEntity;

/**
 * @author James G. Willmore
 *
 */
public abstract class AbstractRepositoryImpl/*<T extends PersistedEntity, ID extends Serializable, R> extends SqlSessionDaoSupport*/ {
//
//  /** The SLF4J Logger. */
//  @SuppressWarnings("unused")
//  private static final Logger LOGGER = LoggerFactory.getLogger(AbstractRepositoryImpl.class);
//
//  /** The sql session factory. */
//  @Autowired
//  private SqlSessionFactory sqlSessionFactory;
//  
//  @Autowired
//  private R mapper;
//
//  /**
//   * Creates the persisted entity.
//   *
//   * @param entity the entity
//   * @return the id
//   */
//  public String create(T entity) {
//
//  }
//
//  /**
//   * Read all persisted entities.
//   *
//   * @return the list
//   */
//  public List<T> readAll() {
//
//  }
//
//  /**
//   * Read the persisted entity with the given UUID.
//   *
//   * @param uuid the UUID
//   * @return the t
//   */
//  public T readById(ID uuid) {
//
//  }
//
//  /**
//   * Update the given persisted entity.
//   *
//   * @param entity the entity
//   */
//  public void update(T entity) {
//
//  }
//
//  /**
//   * Delete the given entity.
//   *
//   * @param entity the entity
//   */
//  public void delete(T entity) {
//
//  }
//
//  /**
//   * Delete the given entity by the given UUID.
//   *
//   * @param uuid the uuid
//   */
//  public void delete(ID uuid) {
//
//  }
}
