/**
           Copyright 2015, James G. Willmore

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

import java.io.Serializable;
import java.util.List;

import net.ljcomputing.entity.PersistedEntity;

/**
 * MyBatis mapper interface
 * 
 * @author James G. Willmore
 * @param <T> the persisted entity generic type
 * @param <V> the id of the persisted entity generic type
 */
public interface MyBatisMapper<T extends PersistedEntity, V extends Serializable> {

  /**
   * Creates the persisted entity.
   *
   * @param entity the entity
   * @return the id
   */
  V create(T entity);

  /**
   * Read all persisted entities.
   *
   * @return the list
   */
  List<T> readAll();

  /**
   * Read the persisted entity with the given id.
   *
   * @param id the id
   * @return the t
   */
  T readById(V id);

  /**
   * Update the given persisted entity.
   *
   * @param entity the entity
   */
  void update(T entity);

  /**
   * Delete the given entity.
   *
   * @param entity the entity
   */
  void delete(T entity);

  /**
   * Delete the given entity by the given id.
   *
   * @param id the id
   */
  void delete(V id);
}
