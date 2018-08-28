import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

var kotlin_version = "1.2.61"

group = "xyz.abhinay"
version = "1.0-SNAPSHOT"

plugins {
    kotlin("jvm") version "1.2.61"
    application
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_10
    targetCompatibility = JavaVersion.VERSION_1_10
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

repositories {
    jcenter()
}

// Add Kotlin stdlib
dependencies {
    implementation(kotlin("stdlib", kotlin_version))
}

// Compiles the Java classes within Kotlin compiled output dir
// Helps module-info.java and kt files to compile in the same output dir
val compileKotlin: KotlinCompile by tasks
val compileJava: JavaCompile by tasks
compileJava.destinationDir = compileKotlin.destinationDir

// Assign classpath to module-path 
compileJava.apply {
    dependsOn("compileKotlin")
    doFirst {
        options.compilerArgs = listOf(
            "--module-path", classpath.asPath
        )
        classpath = files()
    }
}

application.mainClassName = "$group.Main"
