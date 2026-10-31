import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidFeatureConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {

            pluginManager.apply("myapp.android.library")

            // common dependency for all the module
            dependencies.add(
                "implementation",
                project(":core:navigation")
            )
        }
    }
}