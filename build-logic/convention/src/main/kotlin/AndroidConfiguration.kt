import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.JavaVersion

private const val COMPILE_SDK = 37
private const val MIN_SDK = 26
private const val TARGET_SDK = 37

fun ApplicationExtension.configureAndroidApplication() {

    compileSdk = COMPILE_SDK

    defaultConfig {
        minSdk = MIN_SDK
        targetSdk = TARGET_SDK
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

fun LibraryExtension.configureAndroidLibrary() {

    compileSdk = COMPILE_SDK

    defaultConfig {
        minSdk = MIN_SDK
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}