plugins {
    id("minecraft-setup")
    id("publish-setup")
}

impactMod {
    modId.set("impact_mixinmodule")
    modName.set("Impact | Mixin Module")
    modGroup.set("space.gtimpact.mixinmodule")
    mavenGroup.set("space.impact")
    mavenUrl.set("https://maven.accident.space/repository/maven-releases/")
    usesMixins.set(true)
    mixinDebug.set(true)
}

buildConfig {
    useJavaOutput()
    packageName(impactMod.modGroup.get())
    buildConfigField("String", "MODID", "\"${impactMod.modId.get()}\"")
    buildConfigField("String", "MODNAME", "\"${impactMod.modName.get()}\"")
    buildConfigField("String", "VERSION", "\"${project.version}\"")
    buildConfigField("String", "GROUPNAME", "\"${impactMod.modGroup.get()}\"")
}

dependencies {
    implementation("net.industrial-craft:industrialcraft-2:2.2.828-experimental:dev")
    api("com.github.GTNewHorizons:EnderCore:0.3.0:dev")
    implementation("com.github.GTNewHorizons:EnderIO:2.4.16:dev")
    implementation("curse.maven:cofh-core-69162:2388751")
    implementation(fileTree("libs") {
        include("*.jar")
    })
}
