/*
 * Copyright 2007-2020 Ping Identity Corporation
 * All Rights Reserved.
 */
/*
 * Copyright (C) 2007-2020 Ping Identity Corporation
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
package com.unboundid.ldap.sdk;



import java.lang.reflect.Field;

import org.testng.annotations.Test;



/**
 * This class provides a set of test cases for the SearchScope class.
 */
public class SearchScopeTestCase
       extends LDAPSDKTestCase
{
  /**
   * Tests to ensure that all predefined search scope values are included in the
   * array returned by the values method.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test()
  public void testValuesIncludesAllPredefinedValues()
         throws Exception
  {
    for (Field f : SearchScope.class.getFields())
    {
      if (f.getDeclaringClass().equals(SearchScope.class) &&
          f.getType().equals(SearchScope.class))
      {
        SearchScope predefined = (SearchScope) f.get(null);

        boolean found = false;
        for (SearchScope s : SearchScope.values())
        {
          if (s == predefined)
          {
            found = true;
            break;
          }
        }

        assertTrue(found,
             "Search scope " + predefined.getName() + " not in values()");
      }
    }
  }



  /**
   * Tests the {@code valueOf} method.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test()
  public void testValueOf()
         throws Exception
  {
    assertEquals(SearchScope.valueOf(0), SearchScope.BASE);
    assertSame(SearchScope.valueOf(0), SearchScope.BASE);

    assertEquals(SearchScope.valueOf(1), SearchScope.ONE);
    assertSame(SearchScope.valueOf(1), SearchScope.ONE);

    assertEquals(SearchScope.valueOf(2), SearchScope.SUB);
    assertSame(SearchScope.valueOf(2), SearchScope.SUB);

    assertEquals(SearchScope.valueOf(3), SearchScope.SUBORDINATE_SUBTREE);
    assertSame(SearchScope.valueOf(3), SearchScope.SUBORDINATE_SUBTREE);

    SearchScope s1 = SearchScope.valueOf(4);
    SearchScope s2 = SearchScope.valueOf(4);
    assertEquals(s1, s2);
    assertEquals(s1.hashCode(), s2.hashCode());
    assertSame(s1, s2);
  }



  /**
   * Tests to ensure that all predefined search scope values are handled by
   * valueOf.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test()
  public void testValueOfIncludesAllPredefinedValues()
         throws Exception
  {
    for (Field f : SearchScope.class.getFields())
    {
      if (f.getDeclaringClass().equals(SearchScope.class) &&
          f.getType().equals(SearchScope.class))
      {
        SearchScope predefined = (SearchScope) f.get(null);
        SearchScope valueOf =
             SearchScope.valueOf(predefined.intValue());
        SearchScope definedValueOf =
             SearchScope.definedValueOf(predefined.intValue());

        assertEquals(predefined, valueOf);
        assertEquals(predefined, definedValueOf);
        assertEquals(predefined.intValue(), valueOf.intValue());
        assertEquals(predefined.intValue(), definedValueOf.intValue());
        assertEquals(predefined.hashCode(), valueOf.hashCode());
        assertEquals(predefined.hashCode(), definedValueOf.hashCode());
        assertEquals(predefined.getName(), valueOf.getName());
        assertEquals(predefined.getName(), definedValueOf.getName());
        assertSame(predefined, valueOf);
        assertSame(predefined, definedValueOf);
      }
    }
  }



  /**
   * Tests to ensure proper valueOf handling for undefined search scope values.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test()
  public void testValueOfUndeinfedValues()
         throws Exception
  {
    SearchScope valueOf = SearchScope.valueOf(4);
    assertNotNull(valueOf);
    assertEquals(valueOf.intValue(), 4);

    SearchScope definedValueOf = SearchScope.definedValueOf(4);
    assertNull(definedValueOf);
  }



  /**
   * Tests the {@code equals} method.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test()
  public void testEquals()
         throws Exception
  {
    assertFalse(SearchScope.BASE.equals(null));
    assertTrue(SearchScope.BASE.equals(SearchScope.BASE));
    assertFalse(SearchScope.BASE.equals(SearchScope.SUB));
    assertTrue(SearchScope.BASE.equals(SearchScope.valueOf(0)));
    assertFalse(SearchScope.BASE.equals("foo"));
  }
}
