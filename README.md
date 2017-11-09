# Weather-Forecast
Android application for fetching latest weather information Edit

## System Requirements

1. Android Studio 3
2. Gradle version 3.0.0
3. Minimum SDK: 17

## Getting Started

1. Clone the project.
2. Get Dark Sky API Key (https://darksky.net/dev)
3. Find ```secret.gradle``` inside the project and replace ```<DARK_SKY_API_KEY>``` with your api key. If you are a Unix user, simply cd into the directory and call ```sed -i -e 's/<DARK_SKY_API_KEY>/YOUR_API_KEY/g' Weather-Forecast/buildgradle/secret.gradle``` where ```YOUR_API_KEY``` is your Dark Sky API Key.
4. Build project and enjoy.

## Third Party Libraries

1. RxJava, RxAndroid, and RxBinding
2. Retrofit and okHttp3
3. Dagger 2
4. ButterKnife
5. LeakCanary
6. SkyCons (https://github.com/torryharris/Skycons)
