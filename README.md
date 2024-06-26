
# Unsplash Paging

This project is created for consuming unsplash api. We used retrofit to consume api inthis projec and Pagging-3 library for pagination. Hope would you enjoy this sample project.


## Authors

- [@chandravir singh](https://github.com/ChandravirRaj/unsplash_paging_android/tree)


## ### Gradle

```plugins {
    id 'com.android.application'
    id 'org.jetbrains.kotlin.android'
    id 'kotlin-kapt'
    id 'com.google.dagger.hilt.android'
    id 'kotlin-parcelize'
}
```

android {
namespace 'com.androboy.unsplashpaging'
compileSdk 34

    defaultConfig {
        applicationId "com.androboy.unsplashpaging"
        minSdk 24
        targetSdk 34
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_17
        targetCompatibility JavaVersion.VERSION_17
    }
    buildFeatures {
        viewBinding = true
    }

    kotlinOptions {
        jvmTarget = '17'
    }
}
## Dependencies

implementation 'androidx.core:core-ktx:1.8.0'
implementation 'androidx.appcompat:appcompat:1.6.1'
implementation 'com.google.android.material:material:1.11.0'
implementation 'androidx.constraintlayout:constraintlayout:2.1.4'


    // lib for livedata and view model
    implementation 'com.google.code.gson:gson:2.10.1'
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.6.1"
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1"

    // Retrofit & OkHttp
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation 'com.squareup.okhttp3:okhttp:4.10.0'
    implementation 'com.squareup.okhttp3:logging-interceptor:4.9.0'

    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1'
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1'

    implementation "com.google.dagger:hilt-android:2.44"
    kapt "com.google.dagger:hilt-compiler:2.44"

    implementation "androidx.paging:paging-runtime:3.2.1"
    implementation 'com.karumi:dexter:6.2.3'


## Requirements
- Android minimum API 24+
- Android Studio Flamingo
- Kotlin 1.8
- Use AndroidX artifacts when creating your project
- [Unsplash API Access Key and Secret Key](https://unsplash.com/documentation#registering-your-application)
## API Integration

@GET("photos")
suspend fun loadPhotos(
@Query("client_id") clientId: String,
@Query("page") page: Int,
@Query("per_page") pageSize: Int
): Response<List<UnsplashPhoto>>


    "your access key",
    "your secret key"

    - [Unsplash API Access Key and Secret Key](https://unsplash.com/documentation#registering-your-application)

## Demo ----->>
Branch Name- dev
[https://drive.google.com/file/d/17H-BDK_APgS8a9C8eyAiydu9L4UcWJRW/view?usp=sharing](https://drive.google.com/file/d/17H-BDK_APgS8a9C8eyAiydu9L4UcWJRW/view?usp=sharing)


## Compose Setup in Existing Project

- buildFeatures {
  compose true
  }

- composeOptions {
  kotlinCompilerExtensionVersion = "1.4.5"
  kotlinCompilerVersion '1.4.32'
  }

- dependencies
    - implementation ("androidx.paging:paging-compose-android:3.3.0-beta01")

    - implementation "androidx.compose.ui:ui:1.6.5"
    - implementation "androidx.compose.material:material:1.6.5"
    - implementation "androidx.compose.ui:ui-tooling:1.6.5"
    - implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.7.0'
    - implementation 'androidx.activity:activity-compose:1.8.2'
    - implementation("io.coil-kt:coil-compose:2.4.0")


- Add Composable activity
    - ImagesGridActivity


## Compose UI Demo ----->>
Branch Name- dev_compose

Insert gif or link to demo

[https://drive.google.com/file/d/1G5zv1amA1gpxhN6cjchqB6LmnweIhfQ9/view?usp=sharing](https://drive.google.com/file/d/17H-BDK_APgS8a9C8eyAiydu9L4UcWJRW/view?usp=sharing)

