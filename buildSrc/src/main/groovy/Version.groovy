import org.gradle.api.artifacts.dsl.RepositoryHandler

class Version {

    static compileSdkVersion = 29
    static buildToolsVersion = '29.0.2'
    static minSdkVersion = 23
    static targetSdkVersion = 29
    static versionCode = 1
    static versionName = '1.0.0'

    static kotlin_version = '1.3.61'


    static dependencies = [
            test     : [
                    java_junit: "junit:junit:4.12",
                    junit     : "androidx.test.ext:junit:1.1.1",
                    espresso  : "androidx.test.espresso:espresso-core:3.2.0",
            ],

            androidX : [
                    appcompat       : "androidx.appcompat:appcompat:1.1.0",
                    constraintlayout: "androidx.constraintlayout:constraintlayout:1.1.3",
                    core            : "androidx.core:core-ktx:1.1.0"
            ],

            lifecycle: [
                    extensions: "androidx.lifecycle:lifecycle-extensions:2.1.0"
            ],

            material : "com.google.android.material:material:1.0.0",

            kotlin   : "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"

    ]

    static addRepos(RepositoryHandler handler) {
        handler.google()
        handler.jcenter()
    }
}