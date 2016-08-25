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

  /** The created time stamp. */
  private Long createdTs;

  /** The modified time stamp. */
  private Long modifiedTs;
  
  /**
   * Instantiates a new abstract persisted entity.
   */
  public AbstractPersistedEntity() {
    super();
    createdAt();
    setModifiedTs(getCreatedTs());
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
   * Update the created time stamp with the current date.
   */
  protected void createdAt() {
    this.createdTs = new Date().getTime();
  }

  /**
   * Update the modified time stamp with the current date.
   */
  protected void modifiedAt() {
    this.modifiedTs = new Date().getTime();
  }

  /**
   * @see net.ljcomputing.entity.AbstractDomain#toString()
   */
  @Override
  public String toString() {
    return "AbstractPersistedEntity [" + super.toString() + ", createdTs=" + createdTs + ", modifiedTs=" + modifiedTs + "]";
  }
}
