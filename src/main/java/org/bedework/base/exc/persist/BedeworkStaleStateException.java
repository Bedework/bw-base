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

package org.bedework.base.exc.persist;

import org.bedework.base.exc.BedeworkException;

import static org.bedework.base.exc.BedeworkErrorCode.staleState;

/** Exception that indicates something changed in the db while we were away.
 *
 * @author Mike Douglass
 */
public class BedeworkStaleStateException extends BedeworkException {
  /** Constructor
   *
   */
  public BedeworkStaleStateException() {
    super(staleState);
  }

  /** Constructor
  *
   * @param t Throwable
   */
  public BedeworkStaleStateException(Throwable t) {
    super(t);
  }

  /** Constructor
  *
   * @param s String
   */
  public BedeworkStaleStateException(String s) {
    super(staleState, s);
  }
}
