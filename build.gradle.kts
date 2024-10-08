plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.hibernate.orm:hibernate-platform:6.6.0.Final"))
    implementation("org.hibernate.orm:hibernate-core")
    implementation("jakarta.transaction:jakarta.transaction-api")
    implementation("org.postgresql:postgresql:42.7.4")

    testImplementation("org.junit.jupiter:junit-jupiter:5.10.3")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass = "no.hvl.dat250.jpa.tutorial.basicexample.Main"
}


tasks.named<Test>("test") {
    useJUnitPlatform()
}
