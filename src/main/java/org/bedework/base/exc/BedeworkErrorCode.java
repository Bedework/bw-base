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

/** General error codes for bedework
 *
 * @author Mike Douglass douglm
 */
public interface BedeworkErrorCode {
  /* Property names used as message value. These should be used to
   * retrieve a localized message and can also be used to identify the
   * cause of the exception.
   */

  /** Not allowed to set values */
  String envCannotSetValues =
      "org.bedework.exception.envcannotsetvalues";

  /** Multiple getters for property xxx */
  String envMultipleGetters =
      "org.bedework.exception.envmultiplegetters";

  /** No getters for property xxx */
  String envNoGetters =
      "org.bedework.exception.envnogetters";

  /** Bad date */
  String badDate =
      "org.bedework.error.bad.date";

  /** */
  String badRequest = "org.bedework.exception.badrequest";

  /** */
  String badResponse = "org.bedework.exception.badresponse";

  /** */
  String databaseError = "org.bedework.exception.databaseerror";

  /** The name for an entity already exists in the context */
  String duplicateName =
          "org.bedework.exception.duplicatename";

  /** Used to indicate something you're not allowed to do -
   * not an access exception
   */
  String forbidden = "org.bedework.exception.forbidden";

  /** */
  String staleState =
      "org.bedework.exception.stalestate";
}
