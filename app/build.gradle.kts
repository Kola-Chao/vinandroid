plugins {
    alias(libs.plugins.vinandroid.android.application)
    alias(libs.plugins.vinandroid.android.application.compose)
}

android {
    namespace = "com.example.vinandroid"

    defaultConfig {
        applicationId = "com.example.vinandroid"
        versionCode = 100
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }

    namespace = "com.example.vinandroid"
}

dependencies {
//    implementation(project(":core:common"))
//    implementation(project(":core:data"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.hilt.android)
    implementation(libs.coil.kt)
    implementation(libs.androidx.metrics)
}