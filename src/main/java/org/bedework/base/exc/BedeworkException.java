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

/** Exception somewhere in bedework
 * <p>You may be asking why an unchecked exception?
 *
 * <p>I became convinced after years of working with large
 * applications that checked exceptions are a nuisance to evil.
 *
 * <p>Eventually, every method has a "throws MyException" on it
 * because we wrap lower checked or unchecked exceptions in our
 * custom exception. Given that we allow that exception for every
 * method, why list it?
 *
 * <p>Here are some links - mnostly to old posts but still valid:
 * <ul>
 *   <li><a href="http://userstories.blogspot.com/2008/12/checked-exception-why-debat-is-not-over.html">http://userstories.blogspot.com/2008/12/checked-exception-why-debat-is-not-over.html</a></li>
 *   <li><a href="http://wiki.c2.com/?CheckedExceptionsAreOfDubiousValue">http://wiki.c2.com/?CheckedExceptionsAreOfDubiousValue</a></li>
 *   <li><a href="https://radio-weblogs.com/0122027/stories/2003/04/01/JavasCheckedExceptionsWereAMistake.html">https://radio-weblogs.com/0122027/stories/2003/04/01/JavasCheckedExceptionsWereAMistake.html</a></li>
 * </ul>
 *
 * @author Mike Douglass douglm   rpi.edu
 */
public class BedeworkException extends RuntimeException {
  private String extra;

  /** Constructor
   *
   */
  public BedeworkException() {
    super();
  }

  /**
   * @param t
   */
  public BedeworkException(final Throwable t) {
    super(t);
  }

  /**
   * @param s
   */
  public BedeworkException(final String s) {
    super(s);
  }

  /**
   * @param s  - retrieve with getMessage(), property ame
   * @param extra String extra text
   */
  public BedeworkException(final String s, final String extra) {
    super(s);
    this.extra = extra;
  }

  /**
   * @return String extra text
   */
  public String getExtra() {
    return extra;
  }

  /**
   * @return String message and 'extra'
   */
  @Override
  public String getMessage() {
    if (getExtra() != null) {
      return super.getMessage() + "\t" + getExtra();
    }

    return super.getMessage();
  }

  /**
   * @return String message without 'extra'
   */
  public String getDetailMessage() {
    return super.getMessage();
  }
}
