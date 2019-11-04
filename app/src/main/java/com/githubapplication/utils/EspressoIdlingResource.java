/*
 * Copyright 2015, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.githubapplication.utils;

import androidx.test.espresso.idling.CountingIdlingResource;

/**
 * @author Akash Bisariya
 */
public class EspressoIdlingResource {

    private static final String RESOURCE_GET_TRENDING_REPOSITORY = "GetTrendingRepository";


    private static CountingIdlingResource mCountingIdlingResourceGetTrendingRepository = new CountingIdlingResource(RESOURCE_GET_TRENDING_REPOSITORY);

    public static void increment() {
        mCountingIdlingResourceGetTrendingRepository.increment();

    }

    public static void decrement() {
        mCountingIdlingResourceGetTrendingRepository.decrement();
    }

    public static CountingIdlingResource getIdlingResource() {
        return mCountingIdlingResourceGetTrendingRepository;

    }
}
