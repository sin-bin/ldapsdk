/*
 * Copyright 2011-2020 Ping Identity Corporation
 * All Rights Reserved.
 */
/*
 * Copyright 2011-2020 Ping Identity Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/*
 * Copyright (C) 2011-2020 Ping Identity Corporation
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License (GPLv2 only)
 * or the terms of the GNU Lesser General Public License (LGPLv2.1 only)
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see <http://www.gnu.org/licenses>.
 */
package com.unboundid.ldap.sdk.unboundidds.extensions;



import org.testng.annotations.Test;

import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.ldap.sdk.Control;
import com.unboundid.ldap.sdk.ExtendedRequest;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.LDAPSDKTestCase;



/**
 * This class provides a set of test cases for the end administrative
 * transaction extended request.
 */
public final class EndAdministrativeSessionExtendedRequestTestCase
       extends LDAPSDKTestCase
{
  /**
   * Tests the behavior when trying to create a request without any controls.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test()
  public void testWithoutControls()
         throws Exception
  {
    EndAdministrativeSessionExtendedRequest r =
         new EndAdministrativeSessionExtendedRequest();
    r = new EndAdministrativeSessionExtendedRequest(r);
    r = r.duplicate();

    assertNotNull(r.getExtendedRequestName());

    assertNotNull(r.toString());
  }



  /**
   * Tests the behavior when trying to create a request with controls.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test()
  public void testWithControls()
         throws Exception
  {
    final Control[] controls =
    {
      new Control("1.2.3.4"),
      new Control("1.2.3.5", true)
    };

    EndAdministrativeSessionExtendedRequest r =
         new EndAdministrativeSessionExtendedRequest(controls);
    r = new EndAdministrativeSessionExtendedRequest(r);
    r = r.duplicate();

    assertNotNull(r.getExtendedRequestName());

    assertNotNull(r.toString());
  }



  /**
   * Tests the behavior when trying to decode a request that has a value.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test(expectedExceptions = { LDAPException.class })
  public void testRequestWithValue()
         throws Exception
  {
    new EndAdministrativeSessionExtendedRequest(new ExtendedRequest(
         EndAdministrativeSessionExtendedRequest.END_ADMIN_SESSION_REQUEST_OID,
         new ASN1OctetString("foo")));
  }
}
