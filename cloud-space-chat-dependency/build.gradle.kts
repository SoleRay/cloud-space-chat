plugins {
    `java-platform`
}

javaPlatform.allowDependencies()

val spring_boot_version = "2.5.4"
val netty_version = "4.1.67.Final"

dependencies {

    api("org.projectlombok:lombok:1.18.18")

    constraints {
        api("org.springframework.boot:spring-boot-starter:${spring_boot_version}")
        api("org.springframework.boot:spring-boot-starter-web:${spring_boot_version}")
        api("io.netty:netty-all:${netty_version}")
        api("com.google.protobuf:protobuf-java:3.17.3")
        api("com.google.protobuf.nano:protobuf-javanano:3.1.0")
    }
}
