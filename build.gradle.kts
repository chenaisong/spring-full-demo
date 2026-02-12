plugins {
	java
	id("org.springframework.boot") version "3.4.2"
	id("io.spring.dependency-management") version "1.1.7"
	id("org.graalvm.buildtools.native") version "0.10.6"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
description = "Demo project for Spring Boot"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	// Web & API 文档
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.0") // 新增

    // 中间件
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("org.springframework.boot:spring-boot-starter-amqp")
    implementation("org.springframework.kafka:spring-kafka")
    
    // AOP & 日志 (按之前要求)
    implementation("org.springframework.boot:spring-boot-starter-aop")
    implementation("org.springframework.boot:spring-boot-starter-log4j2")



	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.amqp:spring-rabbit-test")
	testImplementation("org.springframework.kafka:spring-kafka-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}
// 【关键步骤】全局封杀默认日志：无论哪个依赖带进来的 logging，统统去掉
configurations.all {
    exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
    // 额外保险：直接排除 logback 核心包
    exclude(group = "ch.qos.logback", module = "logback-classic")
    exclude(group = "ch.qos.logback", module = "logback-core")
}
tasks.withType<Test> {
	useJUnitPlatform()
}
