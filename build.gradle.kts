plugins {
	java
	id("org.springframework.boot") version "3.5.3"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "io.shnflrsc"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	implementation("org.dizitart:nitrite-mvstore-adapter")
	implementation(platform("org.dizitart:nitrite-bom:4.3.0"))
	implementation("org.dizitart:nitrite")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
