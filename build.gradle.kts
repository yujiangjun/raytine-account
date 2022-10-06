plugins {
    id("java")
    id("org.springframework.boot") version("2.7.4")
    id("io.spring.dependency-management") version ("1.0.14.RELEASE")
}

group = "com.yujiangjun"
version = "1.0-SNAPSHOT"

configurations{
    compileOnly{
        extendsFrom(configurations.annotationProcessor.get())
    }
}
configurations.all{
    exclude("org.springframework.boot","spring-boot-starter-logging")
//    exclude(null,"logback-classic")
//    exclude(null,"logback-core")
}
repositories {
    maven{
        setUrl("https://maven.aliyun.com/repository/public/")
    }
    mavenCentral()
}

dependencies {
    implementation("com.auth0:java-jwt:3.8.3")
    implementation("com.github.ulisesbocchio:jasypt-spring-boot-starter:3.0.4")
    implementation("cn.hutool:hutool-all:5.8.8")
    implementation("com.lmax:disruptor:3.4.4")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-log4j2")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("mysql:mysql-connector-java:8.0.30")
    implementation("com.baomidou:mybatis-plus-boot-starter:3.5.2")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

//tasks.getByName<Test>("test") {
//    useJUnitPlatform()
//}