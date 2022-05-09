package com.example.miniproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.asLiveData
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    lateinit var userManager: UserManager
    lateinit var useremail : String
    lateinit var userpass : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        userManager = UserManager(this)

        userManager.userEmail.asLiveData().observe(this,{
            useremail = it.toString()
        })

        userManager.userPass.asLiveData().observe(this,{
            userpass = it.toString()
        })
        btn_login.setOnClickListener {
            val emailinput = et_email_login.text.toString()
            val passinput = et_pass_login.text.toString()
//            val emailconfirm = userManager.userEmail.asLiveData().observe(this,{
//                it.toString()
//            })
//            val passconfirm = userManager.userPass.asLiveData().observe(this,{
//                it
//            })

            if (emailinput.isEmpty() && passinput.isEmpty()){
                et_email_login.setError("Isi email atau password")
            }else if(emailinput == useremail && passinput == userpass){
                startActivity(Intent(this,MainActivity::class.java))
            }else{
                Toast.makeText(this,"Try again.",Toast.LENGTH_LONG)
                    .show()
            }
        }

        tv_toReg.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }
    }
}