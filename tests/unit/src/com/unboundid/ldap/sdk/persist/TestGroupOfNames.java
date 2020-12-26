/*
 * Copyright 2010-2020 Ping Identity Corporation
 * All Rights Reserved.
 */
/*
 * Copyright 2010-2020 Ping Identity Corporation
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
 * Copyright (C) 2010-2020 Ping Identity Corporation
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
package com.unboundid.ldap.sdk.persist;



import java.util.Arrays;
import java.util.Date;

import com.unboundid.ldap.sdk.DN;
import com.unboundid.ldap.sdk.Entry;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.LDAPInterface;
import com.unboundid.ldap.sdk.ReadOnlyEntry;



/**
 * This class provides an implementation of an object that can be used to
 * represent groupOfNames objects in the directory.
 * It was generated by the generate-source-from-schema tool provided with the
 * UnboundID LDAP SDK for Java.  It may be customized as desired to better suit
 * your needs.
 */
@LDAPObject(structuralClass="groupOfNames",
            postDecodeMethod="doPostDecode",
            postEncodeMethod="doPostEncode")
public class TestGroupOfNames
{
  // The field to use to hold a read-only copy of the associated entry.
  @LDAPEntryField()
  private ReadOnlyEntry ldapEntry;

  // The field used for RDN attribute cn.
  @LDAPField(inRDN=true,
             filterUsage=FilterUsage.ALWAYS_ALLOWED,
             requiredForEncode=true)
  private String[] cn;

  // The field used for optional attribute businessCategory.
  @LDAPField()
  private String[] businessCategory;

  // The field used for optional attribute description.
  @LDAPField()
  private String[] description;

  // The field used for optional attribute member.
  @LDAPField(lazilyLoad=true)
  private DN[] member;

  // The field used for optional attribute o.
  @LDAPField()
  private String[] o;

  // The field used for optional attribute ou.
  @LDAPField()
  private String[] ou;

  // The field used for optional attribute owner.
  @LDAPField()
  private DN[] owner;

  // The field used for optional attribute seeAlso.
  @LDAPField()
  private DN[] seeAlso;

  // The field used for operational attribute createTimestamp.
  @LDAPField(inAdd=false,
             inModify=false,
             lazilyLoad=true)
  private Date createTimestamp;

  // The field used for operational attribute creatorsName.
  @LDAPField(inAdd=false,
             inModify=false)
  private DN creatorsName;

  // The field used for operational attribute modifiersName.
  @LDAPField(inAdd=false,
             inModify=false)
  private DN modifiersName;

  // The field used for operational attribute modifyTimestamp.
  @LDAPField(inAdd=false,
             inModify=false,
             lazilyLoad=true)
  private Date modifyTimestamp;



  /**
   * Creates a new instance of this object.  All fields will be uninitialized,
   * so the setter methods should be used to assign values to them.
   */
  public TestGroupOfNames()
  {
    // No initialization will be performed by default.  Note that if you set
    // values for any fields marked with an @LDAPField, @LDAPDNField, or
    // @LDAPEntryField annotation, they will be overwritten in the course of
    // decoding initializing this object from an LDAP entry.
  }



  /**
   * Performs any processing that may be necessary after initializing this
   * object from an LDAP entry.
   *
   * @throws  LDAPPersistException  If the generated entry should not be used.
   */
  private void doPostDecode()
          throws LDAPPersistException
  {
    // No processing is needed by default.  You may provide an implementation
    // for this method if custom post-decode processing is needed.
  }



  /**
   * Performs any processing that may be necessary after encoding this object
   * to an LDAP entry.
   *
   * @param  entry  The entry that has been generated.  It may be altered if
   *                desired.
   *
   * @throws  LDAPPersistException  If there is a problem with the object after
   *                                it has been decoded from an LDAP entry.
   */
  private void doPostEncode(final Entry entry)
          throws LDAPPersistException
  {
    // No processing is needed by default.  You may provide an implementation
    // for this method if custom post-encode processing is needed.
  }



  /**
   * Retrieves a read-only copy of the entry with which this object is
   * associated, if it is available.  It will only be available if this object
   * was decoded from or encoded to an LDAP entry.
   *
   * @return  A read-only copy of the entry with which this object is
   *          associated, or {@code null} if it is not available.
   */
  public ReadOnlyEntry getLDAPEntry()
  {
    return ldapEntry;
  }



  /**
   * Retrieves the DN of the entry with which this object is associated, if it
   * is available.  It will only be available if this object was decoded from or
   * encoded to an LDAP entry.
   *
   * @return  The DN of the entry with which this object is associated, or
   *          {@code null} if it is not available.
   */
  public String getLDAPEntryDN()
  {
    if (ldapEntry == null)
    {
      return null;
    }
    else
    {
      return ldapEntry.getDN();
    }
  }



  /**
   * Retrieves the first value for the field associated with the
   * cn attribute, if present.
   *
   * @return  The first value for the field associated with the
   *          cn attribute, or
   *          {@code null} if that attribute was not present in the entry or
   *          does not have any values.
   */
  public String getFirstCn()
  {
    if ((cn == null) ||
        (cn.length == 0))
    {
      return null;
    }
    else
    {
      return cn[0];
    }
  }



  /**
   * Retrieves the values for the field associated with the
   * cn attribute, if present.
   *
   * @return  The values for the field associated with the
   *          cn attribute, or
   *          {@code null} if that attribute was not present in the entry.
   */
  public String[] getCn()
  {
    return cn;
  }



  /**
   * Sets the values for the field associated with the
   * cn attribute.
   *
   * @param  v  The values for the field associated with the
   *            cn attribute.
   */
  public void setCn(final String... v)
  {
    this.cn = v;
  }



  /**
   * Retrieves the first value for the field associated with the
   * businessCategory attribute, if present.
   *
   * @return  The first value for the field associated with the
   *          businessCategory attribute, or
   *          {@code null} if that attribute was not present in the entry or
   *          does not have any values.
   */
  public String getFirstBusinessCategory()
  {
    if ((businessCategory == null) ||
        (businessCategory.length == 0))
    {
      return null;
    }
    else
    {
      return businessCategory[0];
    }
  }



  /**
   * Retrieves the values for the field associated with the
   * businessCategory attribute, if present.
   *
   * @return  The values for the field associated with the
   *          businessCategory attribute, or
   *          {@code null} if that attribute was not present in the entry.
   */
  public String[] getBusinessCategory()
  {
    return businessCategory;
  }



  /**
   * Sets the values for the field associated with the
   * businessCategory attribute.
   *
   * @param  v  The values for the field associated with the
   *            businessCategory attribute.
   */
  public void setBusinessCategory(final String... v)
  {
    this.businessCategory = v;
  }



  /**
   * Retrieves the first value for the field associated with the
   * description attribute, if present.
   *
   * @return  The first value for the field associated with the
   *          description attribute, or
   *          {@code null} if that attribute was not present in the entry or
   *          does not have any values.
   */
  public String getFirstDescription()
  {
    if ((description == null) ||
        (description.length == 0))
    {
      return null;
    }
    else
    {
      return description[0];
    }
  }



  /**
   * Retrieves the values for the field associated with the
   * description attribute, if present.
   *
   * @return  The values for the field associated with the
   *          description attribute, or
   *          {@code null} if that attribute was not present in the entry.
   */
  public String[] getDescription()
  {
    return description;
  }



  /**
   * Sets the values for the field associated with the
   * description attribute.
   *
   * @param  v  The values for the field associated with the
   *            description attribute.
   */
  public void setDescription(final String... v)
  {
    this.description = v;
  }



  /**
   * Retrieves the first value for the field associated with the
   * member attribute as a DN, if present.
   *
   * @return  The first value for the field associated with the
   *          member attribute, or
   *          {@code null} if that attribute was not present in the entry or
   *          does not have any values.
   */
  public DN getFirstMemberDN()
  {
    if ((member == null) ||
        (member.length == 0))
    {
      return null;
    }
    else
    {
      return member[0];
    }
  }



  /**
   * Retrieves the values for the field associated with the
   * member attribute as DNs, if present.
   *
   * @return  The values for the field associated with the
   *          member attribute, or
   *          {@code null} if that attribute was not present in the entry.
   */
  public DN[] getMemberDNs()
  {
    return member;
  }



  /**
   * Retrieves the values for the field associated with the
   * member attribute as objects of the specified type,
   * if present.
   *
   * @param  <T>  The type of object to return.
   *
   * @param  connection  The connection to use to retrieve the entries.  It
   *                     must not be {@code null}.
   * @param  type        The type of object as which the entries should be
   *                     decoded.  It must not be {@code null}, and the class
   *                     must be marked with the {@code LDAPObject} annotation
   *                     type.
   *
   * @return  A {@code PersistedObjects} object that may be used to iterate
   *          across the resulting objects.
   *
   * @throws  LDAPException  If the requested type cannot be used with the LDAP
   *                         SDK persistence framework.
   */
  public <T> PersistedObjects<T> getMemberObjects(
                                      final LDAPInterface connection,
                                      final Class<T> type)
         throws LDAPException
  {
    return PersistUtils.getEntriesAsObjects(member,
         type, connection);
  }



  /**
   * Sets the values for the field associated with the
   * member attribute.
   *
   * @param  v  The values for the field associated with the
   *            member attribute.
   */
  public void setMember(final DN... v)
  {
    this.member = v;
  }



  /**
   * Retrieves the first value for the field associated with the
   * o attribute, if present.
   *
   * @return  The first value for the field associated with the
   *          o attribute, or
   *          {@code null} if that attribute was not present in the entry or
   *          does not have any values.
   */
  public String getFirstO()
  {
    if ((o == null) ||
        (o.length == 0))
    {
      return null;
    }
    else
    {
      return o[0];
    }
  }



  /**
   * Retrieves the values for the field associated with the
   * o attribute, if present.
   *
   * @return  The values for the field associated with the
   *          o attribute, or
   *          {@code null} if that attribute was not present in the entry.
   */
  public String[] getO()
  {
    return o;
  }



  /**
   * Sets the values for the field associated with the
   * o attribute.
   *
   * @param  v  The values for the field associated with the
   *            o attribute.
   */
  public void setO(final String... v)
  {
    this.o = v;
  }



  /**
   * Retrieves the first value for the field associated with the
   * ou attribute, if present.
   *
   * @return  The first value for the field associated with the
   *          ou attribute, or
   *          {@code null} if that attribute was not present in the entry or
   *          does not have any values.
   */
  public String getFirstOu()
  {
    if ((ou == null) ||
        (ou.length == 0))
    {
      return null;
    }
    else
    {
      return ou[0];
    }
  }



  /**
   * Retrieves the values for the field associated with the
   * ou attribute, if present.
   *
   * @return  The values for the field associated with the
   *          ou attribute, or
   *          {@code null} if that attribute was not present in the entry.
   */
  public String[] getOu()
  {
    return ou;
  }



  /**
   * Sets the values for the field associated with the
   * ou attribute.
   *
   * @param  v  The values for the field associated with the
   *            ou attribute.
   */
  public void setOu(final String... v)
  {
    this.ou = v;
  }



  /**
   * Retrieves the first value for the field associated with the
   * owner attribute as a DN, if present.
   *
   * @return  The first value for the field associated with the
   *          owner attribute, or
   *          {@code null} if that attribute was not present in the entry or
   *          does not have any values.
   */
  public DN getFirstOwnerDN()
  {
    if ((owner == null) ||
        (owner.length == 0))
    {
      return null;
    }
    else
    {
      return owner[0];
    }
  }



  /**
   * Retrieves the values for the field associated with the
   * owner attribute as DNs, if present.
   *
   * @return  The values for the field associated with the
   *          owner attribute, or
   *          {@code null} if that attribute was not present in the entry.
   */
  public DN[] getOwnerDNs()
  {
    return owner;
  }



  /**
   * Retrieves the values for the field associated with the
   * owner attribute as objects of the specified type,
   * if present.
   *
   * @param  <T>  The type of object to return.
   *
   * @param  connection  The connection to use to retrieve the entries.  It
   *                     must not be {@code null}.
   * @param  type        The type of object as which the entries should be
   *                     decoded.  It must not be {@code null}, and the class
   *                     must be marked with the {@code LDAPObject} annotation
   *                     type.
   *
   * @return  A {@code PersistedObjects} object that may be used to iterate
   *          across the resulting objects.
   *
   * @throws  LDAPException  If the requested type cannot be used with the LDAP
   *                         SDK persistence framework.
   */
  public <T> PersistedObjects<T> getOwnerObjects(
                                      final LDAPInterface connection,
                                      final Class<T> type)
         throws LDAPException
  {
    return PersistUtils.getEntriesAsObjects(owner,
         type, connection);
  }



  /**
   * Sets the values for the field associated with the
   * owner attribute.
   *
   * @param  v  The values for the field associated with the
   *            owner attribute.
   */
  public void setOwner(final DN... v)
  {
    this.owner = v;
  }



  /**
   * Retrieves the first value for the field associated with the
   * seeAlso attribute as a DN, if present.
   *
   * @return  The first value for the field associated with the
   *          seeAlso attribute, or
   *          {@code null} if that attribute was not present in the entry or
   *          does not have any values.
   */
  public DN getFirstSeeAlsoDN()
  {
    if ((seeAlso == null) ||
        (seeAlso.length == 0))
    {
      return null;
    }
    else
    {
      return seeAlso[0];
    }
  }



  /**
   * Retrieves the values for the field associated with the
   * seeAlso attribute as DNs, if present.
   *
   * @return  The values for the field associated with the
   *          seeAlso attribute, or
   *          {@code null} if that attribute was not present in the entry.
   */
  public DN[] getSeeAlsoDNs()
  {
    return seeAlso;
  }



  /**
   * Retrieves the values for the field associated with the
   * seeAlso attribute as objects of the specified type,
   * if present.
   *
   * @param  <T>  The type of object to return.
   *
   * @param  connection  The connection to use to retrieve the entries.  It
   *                     must not be {@code null}.
   * @param  type        The type of object as which the entries should be
   *                     decoded.  It must not be {@code null}, and the class
   *                     must be marked with the {@code LDAPObject} annotation
   *                     type.
   *
   * @return  A {@code PersistedObjects} object that may be used to iterate
   *          across the resulting objects.
   *
   * @throws  LDAPException  If the requested type cannot be used with the LDAP
   *                         SDK persistence framework.
   */
  public <T> PersistedObjects<T> getSeeAlsoObjects(
                                      final LDAPInterface connection,
                                      final Class<T> type)
         throws LDAPException
  {
    return PersistUtils.getEntriesAsObjects(seeAlso,
         type, connection);
  }



  /**
   * Sets the values for the field associated with the
   * seeAlso attribute.
   *
   * @param  v  The values for the field associated with the
   *            seeAlso attribute.
   */
  public void setSeeAlso(final DN... v)
  {
    this.seeAlso = v;
  }



  /**
   * Retrieves the value for the field associated with the
   * createTimestamp attribute, if present.
   *
   * @return  The value for the field associated with the
   *          createTimestamp attribute, or
   *          {@code null} if the field does not have a value.
   */
  public Date getCreateTimestamp()
  {
    return createTimestamp;
  }



  /**
   * Retrieves the first value for the field associated with the
   * creatorsName attribute as a DN, if present.
   *
   * @return  The first value for the field associated with the
   *          creatorsName attribute, or
   *          {@code null} if the field does not have a value.
   */
  public DN getCreatorsNameDN()
  {
    return creatorsName;
  }



  /**
   * Retrieves the object referenced by the DN held in the
   * creatorsName attribute, if present.
   *
   * @param  <T>  The type of object to return.
   *
   * @param  connection  The connection to use to retrieve the entry.  It must
   *                     not be {@code null}.
   * @param  type        The type of object as which to decode the entry.  It
   *                     must not be {@code null}, and the class must be marked
   *                     with the {@code LDAPObject} annotation type.
   *
   * @return  The object decoded from the entry with the associated DN, or
   *          {@code null} if the field does not have a value or the referenced
   *          entry does not exist.
   *
   * @throws  LDAPException  If a problem occurs while attempting to retrieve
   *                         the entry or decode it as an object of the
   *                         specified type.
   */
  public <T> T getCreatorsNameObject(
                    final LDAPInterface connection,
                    final Class<T> type)
         throws LDAPException
  {
    return PersistUtils.getEntryAsObject(creatorsName,
         type, connection);
  }



  /**
   * Retrieves the first value for the field associated with the
   * modifiersName attribute as a DN, if present.
   *
   * @return  The first value for the field associated with the
   *          modifiersName attribute, or
   *          {@code null} if the field does not have a value.
   */
  public DN getModifiersNameDN()
  {
    return modifiersName;
  }



  /**
   * Retrieves the object referenced by the DN held in the
   * modifiersName attribute, if present.
   *
   * @param  <T>  The type of object to return.
   *
   * @param  connection  The connection to use to retrieve the entry.  It must
   *                     not be {@code null}.
   * @param  type        The type of object as which to decode the entry.  It
   *                     must not be {@code null}, and the class must be marked
   *                     with the {@code LDAPObject} annotation type.
   *
   * @return  The object decoded from the entry with the associated DN, or
   *          {@code null} if the field does not have a value or the referenced
   *          entry does not exist.
   *
   * @throws  LDAPException  If a problem occurs while attempting to retrieve
   *                         the entry or decode it as an object of the
   *                         specified type.
   */
  public <T> T getModifiersNameObject(
                    final LDAPInterface connection,
                    final Class<T> type)
         throws LDAPException
  {
    return PersistUtils.getEntryAsObject(modifiersName,
         type, connection);
  }



  /**
   * Retrieves the value for the field associated with the
   * modifyTimestamp attribute, if present.
   *
   * @return  The value for the field associated with the
   *          modifyTimestamp attribute, or
   *          {@code null} if the field does not have a value.
   */
  public Date getModifyTimestamp()
  {
    return modifyTimestamp;
  }



  /**
   * Retrieves a string representation of this {@code TestGroupOfNames}.
   *
   * @return  A string representation of this {@code TestGroupOfNames}.
   */
  @Override()
  public String toString()
  {
    final StringBuilder buffer = new StringBuilder();
    toString(buffer);
    return buffer.toString();
  }



  /**
   * Appends a string representation of this {@code TestGroupOfNames}
     to the provided buffer.
   *
   * @param  buffer  The buffer to which the string representation should be
   *                 appended.
   */
  public void toString(final StringBuilder buffer)
  {
    buffer.append("TestGroupOfNames(");

    boolean appended = false;
    if (ldapEntry != null)
    {
      appended = true;
      buffer.append("entryDN='");
      buffer.append(ldapEntry.getDN());
      buffer.append('\'');
    }

    if (cn != null)
    {
      if (appended)
      {
        buffer.append(", ");
      }
      appended = true;
      buffer.append("cn=");
      buffer.append(Arrays.toString(cn));
    }

    if (businessCategory != null)
    {
      if (appended)
      {
        buffer.append(", ");
      }
      appended = true;
      buffer.append("businessCategory=");
      buffer.append(Arrays.toString(businessCategory));
    }

    if (description != null)
    {
      if (appended)
      {
        buffer.append(", ");
      }
      appended = true;
      buffer.append("description=");
      buffer.append(Arrays.toString(description));
    }

    if (member != null)
    {
      if (appended)
      {
        buffer.append(", ");
      }
      appended = true;
      buffer.append("member=");
      buffer.append(Arrays.toString(member));
    }

    if (o != null)
    {
      if (appended)
      {
        buffer.append(", ");
      }
      appended = true;
      buffer.append("o=");
      buffer.append(Arrays.toString(o));
    }

    if (ou != null)
    {
      if (appended)
      {
        buffer.append(", ");
      }
      appended = true;
      buffer.append("ou=");
      buffer.append(Arrays.toString(ou));
    }

    if (owner != null)
    {
      if (appended)
      {
        buffer.append(", ");
      }
      appended = true;
      buffer.append("owner=");
      buffer.append(Arrays.toString(owner));
    }

    if (seeAlso != null)
    {
      if (appended)
      {
        buffer.append(", ");
      }
      appended = true;
      buffer.append("seeAlso=");
      buffer.append(Arrays.toString(seeAlso));
    }

    if (createTimestamp != null)
    {
      if (appended)
      {
        buffer.append(", ");
      }
      appended = true;
      buffer.append("createTimestamp=");
      buffer.append(createTimestamp);
    }

    if (creatorsName != null)
    {
      if (appended)
      {
        buffer.append(", ");
      }
      appended = true;
      buffer.append("creatorsName=");
      buffer.append(creatorsName);
    }

    if (modifiersName != null)
    {
      if (appended)
      {
        buffer.append(", ");
      }
      appended = true;
      buffer.append("modifiersName=");
      buffer.append(modifiersName);
    }

    if (modifyTimestamp != null)
    {
      if (appended)
      {
        buffer.append(", ");
      }
      appended = true;
      buffer.append("modifyTimestamp=");
      buffer.append(modifyTimestamp);
    }

    buffer.append(')');
  }
}

