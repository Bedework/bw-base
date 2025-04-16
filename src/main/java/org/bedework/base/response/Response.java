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

import java.io.Serializable;
import java.util.concurrent.ConcurrentLinkedDeque;

import javax.xml.namespace.QName;

/** Base for service responses
 *
 * @author Mike Douglass douglm - spherical cow
 */
public class Response<T extends Response<T>> implements Serializable {
  public enum Status {
    ok,
    
    notFound,

    validationError,

    /** Something is currently running */
    processing,

    /** Something exists that shouldn't */
    exists,

    /** Action disallowed */
    forbidden,

    noAccess,

    /** message will contain more detail **/
    limitExceeded,

    failed
  }
  
  private Status status = Status.ok;
  private String message;
  private QName errorTag;
  private final ConcurrentLinkedDeque<String> warnings =
          new ConcurrentLinkedDeque<>();

  // For internal use to pass exception up.
  private Throwable exception;

  /* Copied from the request */
  private int id;

  public boolean hasWarning() {
    return warnings.isEmpty();
  }

  public T warning(final String val) {
    warnings.add(val);
    return (T)this;
  }

  public Iterable<String> getWarnings() {
    return warnings;
  }

  /**
   *
   * @param val status
   */
  public T setStatus(final Status val) {
    status = val;
    return (T)this;
  }

  /**
   * @return status
   */
  public Status getStatus() {
    return status;
  }

  /**
   *
   * @param val a message
   */
  public T setMessage(final String val) {
    message = val;
    return (T)this;
  }

  /**
   * @return a message or null
   */
  public String getMessage() {
    if (message != null) {
      return message;
    }

    if (exception != null) {
      return exception.getMessage();
    }

    return null;
  }

  /**
   *
   * @param val an error tag
   */
  public T setErrorTag(final QName val) {
    errorTag = val;
    return (T)this;
  }

  public QName getErrorTag() {
    return errorTag;
  }
  
  public boolean isOk() {
    return status == Status.ok;
  }

  public boolean isNotFound() {
    return status == Status.notFound;
  }

  /**
   *
   * @return true for !ok and !notFound
   */
  public boolean isError() {
    return !isOk() && !isNotFound();
  }

  /**
   *
   * @param val an exception
   */
  public T setException(final Throwable val) {
    exception = val;
    return (T)this;
  }

  /**
   * @return an exception or null
   */
  public Throwable getException() {
    return exception;
  }


  /**
   * @param val an id to identify the request
   */
  public T setId(final int val) {
    id = val;
    return (T)this;
  }

  /**
   * @return an id to identify the request
   */
  public int getId() {
    return id;
  }

  public T ok() {
    return setStatus(Status.ok);
  }

  public T ok(final String msg) {
    return setStatus(Status.ok).setMessage(msg);
  }

  public T notFound() {
    return notFound(null);
  }

  public T notFound(final String msg) {
    return setStatus(Status.notFound)
            .setMessage(msg);
  }

  public T notOk(final Status status) {
    return setStatus(status);
  }

  public T notOk(final Status status,
                 final String msg) {
    return setStatus(status)
            .setMessage(msg);
  }

  public T notOk(final Status status,
                 final QName errorTag) {
    return setStatus(status)
            .setErrorTag(errorTag);
  }

  public T fromResponse(final Response<?> from) {
    return setStatus(from.getStatus())
            .setMessage(from.getMessage())
            .setException(from.getException());
  }

  public T error(final Status status) {
    return notOk(status);
  }

  public T error(final String msg) {
    return notOk(Status.failed, msg);
  }

  public T error(final Throwable t) {
    return setException(t).error(t.getLocalizedMessage());
  }

  public T invalid(final String msg) {
    return notOk(Status.validationError, msg);
  }

  public ToString toStringSegment(final ToString ts) {
    return ts.append("status", getStatus())
             .append("message", getMessage())
             .append("id", getId());
  }

  @Override
  public String toString() {
    return toStringSegment(new ToString(this)).toString();
  }
}
