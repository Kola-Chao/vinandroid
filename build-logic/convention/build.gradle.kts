import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

group = "com.example.vinandroid.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

// 依赖配置
dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.compose.gradlePlugin)
    compileOnly(libs.firebase.crashlytics.gradlePlugin)
    compileOnly(libs.firebase.performance.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
    implementation(libs.truth)
}

// 开启插件验证，如果插件存在问题，构建将会失败
tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

// 注册插件
gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "vinandroid.android.application"
            implementationClass = "com.example.buildlogic.AndroidApplicationConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "vinandroid.android.application.compose"
            implementationClass = "com.example.buildlogic.AndroidApplicationComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "vinandroid.android.library"
            implementationClass = "com.example.buildlogic.AndroidLibraryConventionPlugin"
        }
        register("hilt") {
            id = "vinandroid.hilt"
            implementationClass = "com.example.buildlogic.HiltConventionPlugin"
        }
        register("jvmLibrary") {
            id = "vinandroid.jvm.library"
            implementationClass = "com.example.buildlogic.JvmLibraryConventionPlugin"
        }
    }
}