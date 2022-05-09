package com.example.miniproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.asLiveData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var userManager: UserManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userManager = UserManager(this)

        userManager.userNama.asLiveData().observe(this,{
            tv_homeview.text ="Hello, " + it.toString()
        })

        btn_logout.setOnClickListener {
            GlobalScope.launch {
                userManager.clearData()
            }

            startActivity(Intent(this,LoginActivity::class.java))
        }
    }
}