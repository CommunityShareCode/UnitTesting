/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package demo.techinasia.com.myapplication.demo.presentation;

import android.os.Build;

import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;

import demo.techinasia.com.myapplication.BuildConfig;

/**
 * Base class for Robolectric data layer tests.
 * Inherit from this class to create a test.
 */
@RunWith(TestRunner.class)
@Config(
        constants = BuildConfig.class,
        shadows = {},
        application = ApplicationStub.class,
        sdk = Build.VERSION_CODES.N_MR1,
        packageName = "demo.techinasia.com.myapplication")
public abstract class ApplicationTestCase {

}
