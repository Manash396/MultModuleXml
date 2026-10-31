plugins {
    `kotlin-dsl`
}

group = "com.mk.buildlogic"

dependencies {
    implementation(libs.android.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "myapp.android.application"
            implementationClass =
                "AndroidApplicationConventionPlugin"
        }

        register("androidLibrary") {
            id = "myapp.android.library"
            implementationClass =
                "AndroidLibraryConventionPlugin"
        }

        register("androidFeature") {
            id = "myapp.android.feature"
            implementationClass =
                "AndroidFeatureConventionPlugin"
        }
    }
}