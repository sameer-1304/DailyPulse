package com.sameer.dailypulse

import platform.UIKit.UIDevice
import platform.UIKit.UIScreen

actual class Platform(){

    actual val osName: String
        get() = UIDevice.currentDevice.systemName

    actual val osVersion: String
        get() = UIDevice.currentDevice.systemVersion

    actual val deviceModel: String
        get() = UIDevice.currentDevice.model

    actual val density: Int
        get() = UIScreen.mainScreen.scale.toInt()

    actual fun logSystemInfo() {
        println("OS Name: $osName")
        println("OS Version: $osVersion")
        println("Device Model: $deviceModel")
        println("Density: $density")

    }

}