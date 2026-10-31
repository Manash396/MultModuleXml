# Centralize Android Multi-Module Gradle Configuration Using buildSrc and Convention Plugins

Refactor the existing Gradle build logic across `:app`, `:core:navigation`, `:feature:home`, and `:feature:profile` to use `buildSrc` and precompiled Kotlin DSL convention plugins, centralized Android SDK/Java/Kotlin configuration, and the Gradle Version Catalog (`libs.versions.toml`).

## User Review Required

- **Convention Plugin IDs**: We will set up precompiled plugins under `buildSrc` with IDs like `multimodulexml.android.application` and `multimodulexml.android.library`.
- **Centralized Dependencies**: Common dependencies like `fragment-ktx`, `navigation-fragment-ktx`, `appcompat`, `core-ktx`, and test dependencies can be centralized in convention plugins or Version Catalog.

## Open Questions

- None. Architecture and navigation contracts remain untouched.

## Proposed Changes

### `buildSrc` and Convention Plugins
#### [NEW] [build.gradle.kts](file:///E:/Manash_learned/Android/MultiModule/MultiModuleXml/buildSrc/build.gradle.kts)
- Configure `kotlin-dsl` for `buildSrc`.

#### [NEW] [android.application.gradle.kts](file:///E:/Manash_learned/Android/MultiModule/MultiModuleXml/buildSrc/src/main/kotlin/android.application.gradle.kts)
- Precompiled convention plugin for Android application modules (`:app`). Configures compileSdk, minSdk, targetSdk, Java compatibility, and common dependencies.

#### [NEW] [android.library.gradle.kts](file:///E:/Manash_learned/Android/MultiModule/MultiModuleXml/buildSrc/src/main/kotlin/android.library.gradle.kts)
- Precompiled convention plugin for Android library modules (`:core:navigation`, `:feature:home`, `:feature:profile`). Configures compileSdk, minSdk, Java compatibility, and common library dependencies.

### Module `build.gradle.kts` Refactoring
#### [MODIFY] [app/build.gradle.kts](file:///E:/Manash_learned/Android/MultiModule/MultiModuleXml/app/build.gradle.kts)
- Apply `multimodulexml.android.application` convention plugin and clean up duplicated SDK/Java blocks.

#### [MODIFY] [core/navigation/build.gradle.kts](file:///E:/Manash_learned/Android/MultiModule/MultiModuleXml/core/navigation/build.gradle.kts)
- Apply `multimodulexml.android.library` convention plugin.

#### [MODIFY] [feature/home/build.gradle.kts](file:///E:/Manash_learned/Android/MultiModule/MultiModuleXml/feature/home/build.gradle.kts)
- Apply `multimodulexml.android.library` convention plugin.

#### [MODIFY] [feature/profile/build.gradle.kts](file:///E:/Manash_learned/Android/MultiModule/MultiModuleXml/feature/profile/build.gradle.kts)
- Apply `multimodulexml.android.library` convention plugin.

## Verification Plan

### Automated Tests
- Run `./gradlew clean build` to verify all convention plugins compile and all modules build successfully.
