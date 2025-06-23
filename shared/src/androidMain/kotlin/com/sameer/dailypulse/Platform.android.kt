package com.sameer.dailypulse

actual class Platform(){

    actual val osName: String
        get() = "Android"

    actual val osVersion: String
        get() = android.os.Build.VERSION.RELEASE

    actual val deviceModel: String
        get() = android.os.Build.MODEL

    actual val density: Int
        get() = android.content.res.Resources.getSystem().displayMetrics.densityDpi

    actual fun logSystemInfo() {
        println("OS Name: $osName")
        println("OS Version: $osVersion")
        println("Device Model: $deviceModel")
        println("Density: $density")
        }


}