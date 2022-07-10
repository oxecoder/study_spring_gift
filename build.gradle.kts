import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.springframework.boot") version "2.7.1"
  id("io.spring.dependency-management") version "1.0.11.RELEASE"
  kotlin("jvm") version "1.6.21"
  kotlin("plugin.spring") version "1.6.21"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
  compileOnly {
    extendsFrom(configurations.annotationProcessor.get())
  }
}

repositories {
  mavenCentral()
}

dependencies {

  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-validation")// NotEmpty

  implementation("org.mapstruct:mapstruct:1.4.2.Final")
  annotationProcessor("org.mapstruct:mapstruct-processor:1.4.2.Final")

  implementation("com.google.guava:guava:28.2-jre")
  implementation("org.apache.commons:commons-lang3:3.9")

  implementation("org.flywaydb:flyway-core:7.10.0")

  // retrofit
  implementation("com.squareup.retrofit2:retrofit:2.9.0")
  implementation("com.squareup.retrofit2:converter-gson:2.9.0")
  implementation("com.squareup.okhttp3:logging-interceptor:3.9.0")

  // aws sqs
  implementation(
    platform("software.amazon.awssdk:bom:2.15.0")
  )
  implementation("org.springframework.cloud:spring-cloud-aws-messaging:2.2.1.RELEASE")

  runtimeOnly("com.h2database:h2")
  runtimeOnly("mysql:mysql-connector-java")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs = listOf("-Xjsr305=strict")
    jvmTarget = "11"
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
}
