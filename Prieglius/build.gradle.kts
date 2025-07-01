plugins {
    `java-library`
    `maven-publish`
}

repositories {
    mavenCentral()
}

dependencies {
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/LukasPietzschmann/prieglius")
            credentials {
                username = project.findProperty("gpr.user")?.toString() ?: System.getenv("GITHUB_ACTOR")
                password = project.findProperty("gpr.key")?.toString()  ?: System.getenv("TOKEN")
            }
        }
    }
    publications {
        register<MavenPublication>("prieglius") {
            from(components["java"])
            groupId = "io.erb"
            artifactId = "prieglius"
        }
    }
}
