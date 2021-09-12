plugins {
    `java-platform`
}

javaPlatform.allowDependencies()

val spring_boot_version = "2.5.4"
val netty_version = "4.1.67.Final"
val junit_version = "5.6.0"

dependencies {

    api("org.projectlombok:lombok:1.18.18")

    constraints {
        api("org.junit.jupiter:junit-jupiter-api:${junit_version}")
        api("org.junit.jupiter:junit-jupiter-engine:${junit_version}")

        api("org.springframework.boot:spring-boot-starter:${spring_boot_version}")
        api("org.springframework.boot:spring-boot-starter-web:${spring_boot_version}")
        api("org.springframework.boot:spring-boot-starter-data-redis:${spring_boot_version}")
        api("org.springframework.boot:spring-boot-starter-log4j2:${spring_boot_version}")
        api("io.netty:netty-all:${netty_version}")
        api("com.google.protobuf:protobuf-java:3.17.3")
        api("com.google.protobuf.nano:protobuf-javanano:3.1.0")
        api("com.thoughtworks.xstream:xstream:1.4.17")
        api("org.apache.httpcomponents:httpclient:4.5.3")
        api("mysql:mysql-connector-java:5.1.40")
        api("com.alibaba:druid:1.2.5")
        api("com.alibaba:fastjson:1.2.38")
        api("tk.mybatis:mapper-spring-boot-starter:2.1.5")
        api("org.mybatis:mybatis-typehandlers-jsr310:1.0.2")
        api("commons-codec:commons-codec:1.15")
        api("commons-io:commons-io:2.11.0")
    }
}
