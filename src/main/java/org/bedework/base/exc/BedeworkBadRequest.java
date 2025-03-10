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
package org.bedework.base.exc;

import static org.bedework.base.exc.BedeworkErrorCode.badRequest;

/** Exception that indicates someone sent a bad request
 *
 * @author Mike Douglass
 */
public class BedeworkBadRequest extends BedeworkException {
  /** Constructor
   *
   */
  public BedeworkBadRequest() {
    super(badRequest);
  }

  /** Constructor
  *
   * @param t Throwable
   */
  public BedeworkBadRequest(Throwable t) {
    super(t);
  }

  /** Constructor
  *
   * @param s String
   */
  public BedeworkBadRequest(String s) {
    super(badRequest, s);
  }
}
