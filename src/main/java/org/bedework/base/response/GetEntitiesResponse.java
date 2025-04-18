/* ********************************************************************
    Licensed to Jasig under one or more contributor license
    agreements. See the NOTICE file distributed with this work
    for additional information regarding copyright ownership.
    Jasig licenses this file to you under the Apache License,
    Version 2.0 (the "License"); you may not use this file
    except in compliance with the License. You may obtain a
    copy of the License at:

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing,
    software distributed under the License is distributed on
    an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    KIND, either express or implied. See the License for the
    specific language governing permissions and limitations
    under the License.
*/
package org.bedework.base.response;

import org.bedework.base.ToString;

import java.util.ArrayList;
import java.util.Collection;

/** Container for fetching entities.
 *
 * @author Mike Douglass
 */
public class GetEntitiesResponse<T>
        extends Response<GetEntitiesResponse<T>> {
  private Collection<T> entities = new ArrayList<>();

  /**
   *
   * @param val collection of entities
   */
  public GetEntitiesResponse<T> setEntities(final Collection<T> val) {
    entities = val;
    return this;
  }

  /**
   * @return collection of entities
   */
  public Collection<T> getEntities() {
    return entities;
  }

  public GetEntitiesResponse<T> addEntity(final T val) {
    entities.add(val);
    return this;
  }

  public GetEntitiesResponse<T> addAll(final Collection<T> val) {
    entities.addAll(val);
    return this;
  }

  @Override
  public ToString toStringSegment(final ToString ts) {
    return super.toStringSegment(ts)
                .append("entities", getEntities());
  }
}
