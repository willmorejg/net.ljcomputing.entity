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

import java.util.UUID;

import net.ljcomputing.domain.Node;

/**
 * Abstract implementation of a domain class.
 * 
 * @author James G. Willmore
 *
 */
public abstract class AbstractDomain implements Node {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = -5596912472711861850L;

  /** The uuid. */
  private String uuid;

  /**
   * @see net.ljcomputing.domain.Domain#getUuid()
   */
  @Override
  public String getUuid() {
    return uuid;
  }

  /**
   * @see net.ljcomputing.domain.Domain#setUuid(java.lang.String)
   */
  @Override
  public void setUuid(final String uuid) {
    this.uuid = uuid;
  }

  /**
   * @see net.ljcomputing.domain.Domain#createUuid()
   */
  @Override
  public void createUuid() {
    if (uuid == null) {
      final UUID newUuid = UUID.randomUUID();
      uuid = newUuid.toString();
    }
  }

  /**
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "AbstractDomain [uuid=" + uuid + "]";
  }
}
