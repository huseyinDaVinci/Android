/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package barin.com.searchtipsapplication.presentation.navigation;

import android.content.Context;
import android.content.Intent;
import barin.com.searchtipsapplication.data.entity.User;
import barin.com.searchtipsapplication.presentation.model.ITParameters;
import barin.com.searchtipsapplication.presentation.view.activity.TipDetailActivity;
import barin.com.searchtipsapplication.presentation.view.activity.TipListActivity;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * purpose is to navigate between activities.
 */
@Singleton public class Navigator {

  @Inject public Navigator() {
    //empty is needed for di
  }

  public void navigateToTipListActivity(Context context, ITParameters tParameters) {
    if (context != null) {
      Intent launcherIntent = TipListActivity.getCallingIntent(context, tParameters);
      context.startActivity(launcherIntent);
    }
  }

  public void navigateToTipDetailActivity(Context context, User user) {
    if (context != null) {
      Intent intentToLaunch = TipDetailActivity.getCallingIntent(context, user);
      context.startActivity(intentToLaunch);
    }
  }
}
