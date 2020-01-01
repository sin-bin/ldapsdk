/*
 * Copyright 2009-2020 Ping Identity Corporation
 * All Rights Reserved.
 */
/*
 * Copyright (C) 2009-2020 Ping Identity Corporation
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
package com.unboundid.ldap.sdk.unboundidds.logs;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import org.testng.annotations.Test;

import com.unboundid.ldap.sdk.LDAPSDKTestCase;



/**
 * This class provides test coverage for the
 * {@code CompareRequestAccessLogMessage} class.
 */
public class CompareRequestAccessLogMessageTestCase
       extends LDAPSDKTestCase
{
  /**
   * Tests the ability to create a log message from a string containing only a
   * timestamp.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test()
  public void testOnlyTimestamp()
         throws Exception
  {
    // Get a timestamp that doesn't include milliseconds.
    Date d = new Date();
    GregorianCalendar c = new GregorianCalendar();
    c.setTime(d);
    c.set(GregorianCalendar.MILLISECOND, 0);
    d = c.getTime();

    SimpleDateFormat f = new SimpleDateFormat("'['dd/MMM/yyyy:HH:mm:ss Z']'");
    String s = f.format(d);

    CompareRequestAccessLogMessage m = new CompareRequestAccessLogMessage(s);
    m = new CompareRequestAccessLogMessage(m);

    assertNotNull(m);

    assertNotNull(m.getTimestamp());
    assertEquals(m.getTimestamp(), d);

    assertNotNull(m.getNamedValues());
    assertTrue(m.getNamedValues().isEmpty());

    assertNotNull(m.getUnnamedValues());
    assertTrue(m.getUnnamedValues().isEmpty());

    assertNotNull(m.getMessageType());
    assertEquals(m.getMessageType(), AccessLogMessageType.REQUEST);

    assertNotNull(m.getOperationType());
    assertEquals(m.getOperationType(), AccessLogOperationType.COMPARE);

    assertNull(m.getProductName());

    assertNull(m.getInstanceName());

    assertNull(m.getStartupID());

    assertNull(m.getConnectionID());

    assertNull(m.getOperationID());

    assertNull(m.getMessageID());

    assertNull(m.getOrigin());

    assertNull(m.getRequesterDN());

    assertNull(m.getRequesterIPAddress());

    assertNull(m.getIntermediateClientRequest());

    assertNull(m.getOperationPurpose());

    assertNull(m.getDN());

    assertNull(m.getAttributeName());

    assertNull(m.usingAdminSessionWorkerThread());

    assertNull(m.getTriggeredByConnectionID());

    assertNull(m.getTriggeredByOperationID());

    assertNotNull(m.toString());
    assertEquals(m.toString(), s);
  }



  /**
   * Tests the ability to create a log message from a string containing only a
   * basic set of information.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test()
  public void testBasicContents()
         throws Exception
  {
    // Get a timestamp that doesn't include milliseconds.
    Date d = new Date();
    GregorianCalendar c = new GregorianCalendar();
    c.setTime(d);
    c.set(GregorianCalendar.MILLISECOND, 0);
    d = c.getTime();

    SimpleDateFormat f = new SimpleDateFormat("'['dd/MMM/yyyy:HH:mm:ss Z']'");
    String s = f.format(d) + " COMPARE REQUEST conn=1 op=2 msgID=3 " +
               "dn=\"dc=example,dc=com\" attr=\"description\"";

    CompareRequestAccessLogMessage m = new CompareRequestAccessLogMessage(s);
    m = new CompareRequestAccessLogMessage(m);

    assertNotNull(m);

    assertNotNull(m.getTimestamp());
    assertEquals(m.getTimestamp(), d);

    assertNotNull(m.getNamedValues());
    assertFalse(m.getNamedValues().isEmpty());

    assertNotNull(m.getUnnamedValues());
    assertFalse(m.getUnnamedValues().isEmpty());

    assertNotNull(m.getMessageType());
    assertEquals(m.getMessageType(), AccessLogMessageType.REQUEST);

    assertNotNull(m.getOperationType());
    assertEquals(m.getOperationType(), AccessLogOperationType.COMPARE);

    assertNull(m.getProductName());

    assertNull(m.getInstanceName());

    assertNull(m.getStartupID());

    assertNotNull(m.getConnectionID());
    assertEquals(m.getConnectionID(), Long.valueOf(1));

    assertNotNull(m.getOperationID());
    assertEquals(m.getOperationID(), Long.valueOf(2));

    assertNotNull(m.getMessageID());
    assertEquals(m.getMessageID(), Integer.valueOf(3));

    assertNull(m.getOrigin());

    assertNull(m.getRequesterDN());

    assertNull(m.getRequesterIPAddress());

    assertNull(m.getIntermediateClientRequest());

    assertNull(m.getOperationPurpose());

    assertNotNull(m.getDN());
    assertEquals(m.getDN(), "dc=example,dc=com");

    assertNotNull(m.getAttributeName());
    assertEquals(m.getAttributeName(), "description");

    assertNull(m.usingAdminSessionWorkerThread());

    assertNull(m.getTriggeredByConnectionID());

    assertNull(m.getTriggeredByOperationID());

    assertNotNull(m.toString());
    assertEquals(m.toString(), s);
  }



  /**
   * Tests the ability to create a log message from a string containing a
   * complete set of information.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test()
  public void testCompleteContents()
         throws Exception
  {
    // Get a timestamp that doesn't include milliseconds.
    Date d = new Date();
    GregorianCalendar c = new GregorianCalendar();
    c.setTime(d);
    c.set(GregorianCalendar.MILLISECOND, 0);
    d = c.getTime();

    SimpleDateFormat f = new SimpleDateFormat("'['dd/MMM/yyyy:HH:mm:ss Z']'");
    String s = f.format(d) + " COMPARE REQUEST " +
               "product=\"Directory Server\" " +
               "instanceName=\"server.example.com:389\" " +
               "startupID=\"ABCDEFG\" conn=1 op=2 msgID=3 " +
               "origin=\"internal\" requesterIP=\"1.2.3.4\" " +
               "requesterDN=\"uid=test.user,ou=People,dc=example,dc=com\" " +
               "usingAdminSessionWorkerThread=true " +
               "via=\"app='UnboundID Directory Proxy Server'\" " +
               "opPurpose=\"app='Some Client' purpose='foo'\" " +
               "dn=\"dc=example,dc=com\" attr=\"description\" " +
               "triggeredByConn=987 triggeredByOp=654";

    CompareRequestAccessLogMessage m = new CompareRequestAccessLogMessage(s);
    m = new CompareRequestAccessLogMessage(m);

    assertNotNull(m);

    assertNotNull(m.getTimestamp());
    assertEquals(m.getTimestamp(), d);

    assertNotNull(m.getNamedValues());
    assertFalse(m.getNamedValues().isEmpty());

    assertNotNull(m.getUnnamedValues());
    assertFalse(m.getUnnamedValues().isEmpty());

    assertNotNull(m.getMessageType());
    assertEquals(m.getMessageType(), AccessLogMessageType.REQUEST);

    assertNotNull(m.getOperationType());
    assertEquals(m.getOperationType(), AccessLogOperationType.COMPARE);

    assertNotNull(m.getProductName());
    assertEquals(m.getProductName(), "Directory Server");

    assertNotNull(m.getInstanceName());
    assertEquals(m.getInstanceName(), "server.example.com:389");

    assertNotNull(m.getStartupID());
    assertEquals(m.getStartupID(), "ABCDEFG");

    assertNotNull(m.getConnectionID());
    assertEquals(m.getConnectionID(), Long.valueOf(1));

    assertNotNull(m.getOperationID());
    assertEquals(m.getOperationID(), Long.valueOf(2));

    assertNotNull(m.getMessageID());
    assertEquals(m.getMessageID(), Integer.valueOf(3));

    assertNotNull(m.getOrigin());
    assertEquals(m.getOrigin(), "internal");

    assertNotNull(m.getRequesterDN());
    assertEquals(m.getRequesterDN(),
                 "uid=test.user,ou=People,dc=example,dc=com");

    assertNotNull(m.getRequesterIPAddress());
    assertEquals(m.getRequesterIPAddress(), "1.2.3.4");

    assertNotNull(m.getIntermediateClientRequest());
    assertEquals(m.getIntermediateClientRequest(),
                 "app='UnboundID Directory Proxy Server'");

    assertNotNull(m.getOperationPurpose());
    assertEquals(m.getOperationPurpose(),
                 "app='Some Client' purpose='foo'");

    assertNotNull(m.getDN());
    assertEquals(m.getDN(), "dc=example,dc=com");

    assertNotNull(m.getAttributeName());
    assertEquals(m.getAttributeName(), "description");

    assertNotNull(m.usingAdminSessionWorkerThread());
    assertEquals(m.usingAdminSessionWorkerThread(), Boolean.TRUE);

    assertNotNull(m.getTriggeredByConnectionID());
    assertEquals(m.getTriggeredByConnectionID().longValue(), 987L);

    assertNotNull(m.getTriggeredByOperationID());
    assertEquals(m.getTriggeredByOperationID().longValue(), 654L);

    assertNotNull(m.toString());
    assertEquals(m.toString(), s);
  }
}
