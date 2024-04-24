# FlutterCompareAppAndroid
Android version of application that is used to compare mobile app performance across native Android using Jetpack Compose and Flutter through defined test cases to determine the best development approach based on speed and responsiveness.

<img src="https://github.com/kovaccc/FlutterCompareAppAndroid/assets/75457058/080f6f0c-61d2-4b30-aa03-02d2065484b8" width="400" height="900">

<img src="https://github.com/kovaccc/FlutterCompareAppAndroid/assets/75457058/07dbd304-f5cf-4aa6-bd1b-867e632aab95" width="400" height="900">


# Related Flutter Application
- [FlutterCompareApp](https://github.com/kovaccc/FlutterCompareApp)

# Related Documentation
- Comprehensive documentation, performance research, test results, and related graphs can be found in the master thesis [Comparison of Flutter and native Android applications](https://repozitorij.unios.hr/islandora/object/etfos%3A4067)
  
# Supported Features
- Users can register and log in to the app if they are already registered.
- Users can also log out of the app.
- Users can browse a list of images, which is also accessible offline.
- Users can click on an item in the list to view its details.
- Users can open a map to track their current location.

# App Architecture
The app is composed by three main layers.

## Data Layer
The data layer includes repositories, mappers, models, datasources, and DAOs. In the photos feature, data is fetched from the [JSONPlaceholder API](https://jsonplaceholder.typicode.com). The data is then parsed (using Gson Converter) and saved to local database (using Room) utilizing the type-safe entity class `Photo`.

## Domain Layer
The domain layer contains interfaces for repositories (e.g. `PhotosRepository`) implemented in the data layer and defines entities (e.g. `Photo`) central to the application's business logic. In some applications it also includes use cases that encapsulate business rules, making them reusable across the application for improved modularity and maintainability.

## UI Layer
This layer contains all the widgets and screens that interact with data through ViewModels. An example includes observing state from `PhotosViewModel` which maps the results from the data/domain layers to the appropriate UI state attributes, such as photos, isLoading, and error.

# Packages in use
- Kotlin: Used for core app programming.
- Jetpack Compose: declarative UI Toolkit for creating screens and other UI elements.
- [Google Maps Compose](https://github.com/googlemaps/android-maps-compose): For integrating interactive maps within the UI.
- [Google Play Services](https://developers.google.com/android/guides/overview): For location functionalities in the app.
- [Navigation Components](https://developer.android.com/jetpack/compose/navigation): Utilized for managing in-app navigation.
- [AndroidX Components](https://developer.android.com/jetpack/androidx/releases/lifecycle): Supports lifecycle management and UI layer composition.
- [Room Database](https://developer.android.com/jetpack/androidx/releases/room): Manages local database storage and operations.
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android): Provides dependency injection to facilitate scalability and maintainability.
- [Firebase](https://firebase.google.com/docs/android/setup#expandable-11): For analytics, authentication, and real-time database services.
- [Retrofit](https://github.com/JakeWharton/retrofit2-kotlinx-serialization-converter), [OkHttp](https://square.github.io/okhttp/): Handles network requests and data serialization.
- [Glide](https://bumptech.github.io/glide/int/compose.html): For efficient image loading and caching in the app, used in composable functions.
- [GSON](https://github.com/square/retrofit/blob/trunk/retrofit-converters/gson/README.md): Utilized for JSON serialization and deserialization.
- [Firebase Performance Monitoring](https://firebase.google.com/docs/perf-mon): Monitors and optimizes app performance in real-time. Also used to run test cases and compare performance between Android native and Flutter version of application.
