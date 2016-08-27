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

package net.ljcomputing.entity;

import java.util.Date;

/**
 * Abstract implementation of a persisted entity class.
 * 
 * @author James G. Willmore
 *
 */
public abstract class AbstractPersistedEntity extends AbstractDomain implements PersistedEntity {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = -5596912472711861850L;

  /** The id. */
  private Integer id;

  /** The created time stamp. */
  private Long createdTs;

  /** The modified time stamp. */
  private Long modifiedTs;

  /**
   * Instantiates a new abstract persisted entity.
   */
  public AbstractPersistedEntity() {
    super();
  }

  /**
   * Gets the id.
   *
   * @return the id
   */
  public Integer getId() {
    return id;
  }

  /**
   * Sets the id.
   *
   * @param id the new id
   */
  public void setId(final Integer id) {
    this.id = id;
  }

  /**
   * @see net.ljcomputing.entity.PersistedEntity#getCreatedTs()
   */
  @Override
  public Long getCreatedTs() {
    return createdTs;
  }

  /**
   * @see net.ljcomputing.entity.PersistedEntity#setCreatedTs(java.lang.Long)
   */
  @Override
  public void setCreatedTs(final Long createdTs) {
    this.createdTs = createdTs;
  }

  /**
   * @see net.ljcomputing.entity.PersistedEntity#getModifiedTs()
   */
  @Override
  public Long getModifiedTs() {
    return modifiedTs;
  }

  /**
   * @see net.ljcomputing.entity.PersistedEntity#setModifiedTs(java.lang.Long)
   */
  @Override
  public void setModifiedTs(final Long modifiedTs) {
    this.modifiedTs = modifiedTs;
  }

  /**
   * @see net.ljcomputing.entity.PersistedEntity#modifiedAt()
   */
  @Override
  public void modifiedAt() {
    if(createdTs == null) {
      createdTs = new Date().getTime();
    }

    modifiedTs = new Date().getTime();
  }

  /**
   * @see net.ljcomputing.entity.AbstractDomain#toString()
   */
  @Override
  public String toString() {
    return "AbstractPersistedEntity [" + super.toString() + ", id=" + id + ", createdTs="
        + createdTs + ", modifiedTs=" + modifiedTs + "]";
  }
}
