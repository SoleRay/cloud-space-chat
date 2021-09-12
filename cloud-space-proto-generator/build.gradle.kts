import com.google.protobuf.gradle.*
plugins {
    java
    id("com.google.protobuf") version("0.8.17")
}

val grpc_version = "1.40.1"

dependencies {

    implementation(platform(project(":cloud-space-chat-dependency")))
    implementation("com.google.protobuf:protobuf-java")
    implementation("io.grpc:grpc-protobuf:${grpc_version}")
    implementation("io.grpc:grpc-stub:${grpc_version}")
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.17.3"
    }
}

sourceSets {
    main {
        proto{
            srcDirs("src/main/java/cloud/space/proto")
        }
    }
}