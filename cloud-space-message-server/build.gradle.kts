plugins {
    java
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

    implementation(platform(project(":cloud-space-chat-dependency")))
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("io.netty:netty-all")
    implementation("com.google.protobuf:protobuf-java")
    implementation("com.google.protobuf.nano:protobuf-javanano")
    annotationProcessor("org.projectlombok:lombok:1.18.20")
}
