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
package com.unboundid.android.ldap.client;



import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import static com.unboundid.android.ldap.client.Logger.*;



/**
 * This class provides an on-click listener that is meant to begin composing an
 * e-mail message to the specified recipient when the associated view is
 * clicked.
 */
final class EMailClickListener
      implements OnClickListener
{
  /**
   * The tag that will be used for log messages generated by this class.
   */
  private static final String LOG_TAG = "EMailClickListener";



  // The activity that created this on-click listener.
  private final Activity activity;

  // The e-mail address.
  private final String address;



  /**
   * Creates a new e-mail on-click listener that will begin composing a message
   * to the provided address when the associated view is clicked.
   *
   * @param  activity  The activity that created this on-click listener.
   * @param  address   The e-mail address.
   */
  EMailClickListener(final Activity activity, final String address)
  {
    logEnter(LOG_TAG, "<init>", activity, address);

    this.activity = activity;
    this.address  = address;
  }



  /**
   * Indicates that the associated view was clicked and that the user should
   * begin composing an e-mail message.
   *
   * @param  view  The view that was clicked.
   */
  public void onClick(final View view)
  {
    logEnter(LOG_TAG, "onClick", view);

    final Intent i = new Intent(activity, EMailAddressOptions.class);
    i.putExtra(EMailAddressOptions.BUNDLE_FIELD_EMAIL_ADDRESS, address);
    activity.startActivity(i);
  }
}
