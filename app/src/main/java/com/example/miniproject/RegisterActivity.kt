package com.example.miniproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {
    lateinit var userManager: UserManager
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        userManager = UserManager(this)
        btn_reg.setOnClickListener {
            val nama = et_nama.text.toString()
            val umur = et_umur.text.toString().toInt()
            val email = et_email.text.toString()
            val pass = et_pass.text.toString()

            GlobalScope.launch {
                userManager.saveData(nama,umur,email,pass)
            }

            startActivity(Intent(this,LoginActivity::class.java))
            Toast.makeText(this,"Registered successfully",Toast.LENGTH_LONG)
                .show()
        }


    }
}