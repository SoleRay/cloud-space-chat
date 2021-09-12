plugins {
    java
}

configurations {
    "implementation" {
        exclude("org.springframework.boot","spring-boot-starter-logging")
    }
}

dependencies {
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

    implementation(platform(project(":cloud-space-chat-dependency")))
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("org.springframework.boot:spring-boot-starter-log4j2")
    implementation("com.thoughtworks.xstream:xstream")
    implementation("org.apache.httpcomponents:httpclient")
    implementation("mysql:mysql-connector-java")
    implementation("com.alibaba:druid")
    implementation("com.alibaba:fastjson")
    implementation("tk.mybatis:mapper-spring-boot-starter")
    implementation("org.mybatis:mybatis-typehandlers-jsr310")
    implementation("commons-codec:commons-codec")
    implementation("commons-io:commons-io")

    annotationProcessor("org.projectlombok:lombok:1.18.20")
}
