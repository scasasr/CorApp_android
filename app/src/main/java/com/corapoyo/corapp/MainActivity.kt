package com.corapoyo.corapp

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.corapoyo.corapp.data.service.PartnerService

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var test: PartnerService = PartnerService()
        test.getAllPartners()
        println("Hello world")

        val init_Go_To_Register = findViewById<Button>(R.id.init_go_to_register)
        init_Go_To_Register.setOnClickListener{
            initGoToRegister()
        }

    }

    private fun initGoToRegister(){
        val i = Intent(this,RegisterV_Activity::class.java)
        startActivity(i)
    }
}