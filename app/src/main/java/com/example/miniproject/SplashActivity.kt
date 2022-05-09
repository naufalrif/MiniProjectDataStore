package com.example.miniproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.asLiveData

class SplashActivity : AppCompatActivity() {
    lateinit var userManager: UserManager
    lateinit var usernama : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        userManager.userNama.asLiveData().observe(this,{
            usernama = it.toString()
        })

        if (usernama.equals("")){
//            startActivity(Intent(this,LoginActivity::class.java))
            Handler().postDelayed({
                startActivity(Intent(this,LoginActivity::class.java))
            })
        }else{
//            startActivity(Intent(this,MainActivity::class.java))
            Handler().postDelayed({
                startActivity(Intent(this,MainActivity::class.java))
            },2000)
        }

        }
}