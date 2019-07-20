package com.bravostudio.mandiriwth2019

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;

import java.util.*
import kotlin.concurrent.schedule

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Timer("LOADING", false).schedule(1500) {
            goToLogin()
        }
    }

    fun goToLogin() {
        val intent = Intent(this, LoginScreen::class.java)
        startActivity(intent)

        finish()
    }
}
