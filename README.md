# Impact Mixin Module

Forge 1.7.10 mod using the shared [BuildConfig](https://github.com/GT-IMPACT/BuildConfig) build logic.

Gradle Kotlin DSL configuration is in `build.gradle.kts` and `settings.gradle.kts`.
Shared build logic is the `remote-build-logic` Git submodule.

## Build

Clone with submodules, or initialize them in an existing checkout:

```sh
git submodule update --init --recursive
```

Run Gradle with JDK 25. Install JDK 8 for the Minecraft toolchain and runtime.
Gradle discovers local JDKs; `JAVA_HOME_8_X64` or `JAVA8_HOME` can point to JDK 8
if it is installed outside the standard locations.

```sh
./gradlew build
```

Artifacts are written to `build/libs`: the regular JAR is reobfuscated for the
game; `-dev.jar` uses development mappings. Local mod dependencies remain in `libs/`.
The game requires Unimixins 0.3.1 (provided by BuildConfig for development).

```sh
./gradlew runClient
./gradlew publishToMavenLocal
```

Version comes from Git, or the `VERSION` environment variable. Mixin configuration
is tracked in `src/main/resources/mixins.impact_mixinmodule.json`; the build generates
its refmap and the Java `BuildConfig` constants.

Publishing uses the IMPACT releases Maven repository. Set `IMPACT_MAVEN_USER` and
`IMPACT_MAVEN_PASSWORD` for `./gradlew publish`.
