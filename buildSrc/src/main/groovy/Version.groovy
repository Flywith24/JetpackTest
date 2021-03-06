import org.gradle.api.artifacts.dsl.RepositoryHandler

class Version {

    static compileSdkVersion = 29
    static buildToolsVersion = '29.0.2'
    static minSdkVersion = 23
    static targetSdkVersion = 29
    static versionCode = 1
    static versionName = '1.0.0'

    static kotlin_version = '1.3.61'
    static room_version = "2.2.3"
    static retrofit_version = '2.7.1'

    static dependencies = [
            test      : [
                    java_junit: "junit:junit:4.12",
                    junit     : "androidx.test.ext:junit:1.1.1",
                    espresso  : "androidx.test.espresso:espresso-core:3.2.0",
            ],

            androidX  : [
                    appcompat       : "androidx.appcompat:appcompat:1.1.0",
                    constraintlayout: "androidx.constraintlayout:constraintlayout:1.1.3",
                    core            : "androidx.core:core-ktx:1.1.0"
            ],

            lifecycle : [
                    extensions   : "androidx.lifecycle:lifecycle-extensions:2.1.0",
                    livedata_ktx : "androidx.lifecycle:lifecycle-livedata-ktx:2.1.0",
                    viewmodel_ktx: "androidx.lifecycle:lifecycle-viewmodel-ktx:2.1.0",
                    savedstate   : "androidx.lifecycle:lifecycle-viewmodel-savedstate:1.0.0-rc03"
            ],

            navigation: [
                    fragment_ktx: "androidx.navigation:navigation-fragment-ktx:2.1.0",
                    ui_ktx      : "androidx.navigation:navigation-ui-ktx:2.1.0"
            ],
            room      : [
                    runtime : "androidx.room:room-runtime:$room_version",
                    compiler: "androidx.room:room-compiler:$room_version",
                    ktx     : "androidx.room:room-ktx:$room_version",
                    testing : "androidx.room:room-testing:$room_version",
            ],
            retrofit    : [
                    retrofit      : "com.squareup.retrofit2:retrofit:$retrofit_version",
                    converter_gson: "com.squareup.retrofit2:converter-gson:$retrofit_version"
            ],
            paging    : "androidx.paging:paging-runtime-ktx:2.1.1",
            material  : "com.google.android.material:material:1.0.0",
            fragment  : "androidx.fragment:fragment-ktx:1.1.0",

            kotlin    : "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"

    ]

    static addRepos(RepositoryHandler handler) {
        handler.google()
        handler.jcenter()
    }
}