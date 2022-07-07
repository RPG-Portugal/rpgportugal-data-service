import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version "1.7.0"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "com.rpgportugal"
version = "1.0.0"

repositories {
    mavenCentral()
}

val ktorVersion = "2.0.3"
val ktormVersion = "3.5.0"
val hikariCpVersion = "5.0.1"
val arrowVersion = "1.0.2"

dependencies {
    implementation("org.ktorm:ktorm-core:$ktormVersion")
    implementation("io.ktor:ktor-server-core-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-netty-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-default-headers-jvm:$ktorVersion")
    implementation("com.zaxxer:HikariCP:$hikariCpVersion")
    implementation("io.arrow-kt:arrow-core:$arrowVersion")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

tasks.withType<ShadowJar> {
    archiveFileName.set("rpgportugal-data-service.jar")
}