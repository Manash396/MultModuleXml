import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {

            pluginManager.apply("com.android.application")

            extensions.configure<ApplicationExtension> {
                configureAndroidApplication()
            }
            // common dependency for all the module
            dependencies.add(
                "implementation",
                project(":core:navigation")
            )
        }
    }
}