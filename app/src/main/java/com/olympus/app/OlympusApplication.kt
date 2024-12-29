package com.olympus.app

import android.app.Application
import java.lang.Thread.UncaughtExceptionHandler
import android.content.Intent
import kotlin.system.exitProcess
import android.util.Log

/**
 * @author JoseG-asm 
 */
class OlympusApplication : Application() {
    
    companion object {
        @Volatile
        lateinit var instance: OlympusApplication
            private set /** define private setter */
    }
    
    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}