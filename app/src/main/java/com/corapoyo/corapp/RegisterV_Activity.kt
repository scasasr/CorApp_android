package com.corapoyo.corapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.corapoyo.corapp.data.service.PartnerService
import com.corapoyo.corapp.databinding.ActivityMainBinding

class RegisterV_Activity : AppCompatActivity() {
    private var spDocument_type: Spinner?=null

    //private lateinit var binding = ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_vactivity)

        //implementation volver
        val goTo_Back = findViewById<TextView>(R.id.go_to_back_1)
        goTo_Back.setOnClickListener   {
            goToRegister2()
        }
        //

        //Spinner(Select)
        spDocument_type=findViewById(R.id.spinner_document_type)

        val document_Types= arrayOf("Seleccione uno","C.C","T.I","PA","NIT")

        var adapter: ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_spinner_item,document_Types)
        spDocument_type?.adapter = adapter
        //

        //Implementation data transmission
        var serv: PartnerService = PartnerService()

            //press button function
        val btn_Register  =findViewById<Button>(R.id.btn_Register)
        btn_Register.setOnClickListener{
            //Get values by form
            val Etname = findViewById<EditText>(R.id.name_)
            val Etlast_name = findViewById<EditText>(R.id.last_name)
            val Etdocument_number = findViewById<EditText>(R.id.document_number)
            val Etemail= findViewById<EditText>(R.id.email)
            val Etusername = findViewById<EditText>(R.id.username)
            val Etaccount_number= findViewById<EditText>(R.id.account_number)
            val Etpassword = findViewById<EditText>(R.id.password)
            val Etverification_password = findViewById<EditText>(R.id.verification_password)
            val Etphone = findViewById<EditText>(R.id.phone)

            var name: String = Etname.text.toString()
            var last_name:String = Etlast_name.text.toString()
            var document_number:String = Etdocument_number.text.toString()
            var email:String= Etemail.text.toString()
            var username:String = Etusername.text.toString()
            var account_number:String= Etaccount_number.text.toString()
            var password:String = Etpassword.text.toString()
            var verification_password = Etverification_password.text.toString()
            var phone = Etphone.text.toString()
            var role :String = "63bd2b3be32ed030449d64b3"



            //Get value to spinner
            var document_type:String ="Seleccione uno"
            val toast = Toast.makeText(this,"Tipo de documento no valido",Toast.LENGTH_LONG)

            if(spDocument_type?.selectedItem.toString() != "Seleccione uno"){
                document_type= spDocument_type?.selectedItem.toString()
            }else{
                toast.show()
                document_type="Seleccione uno"
            }
            //

            try {
                serv.addPartner(document_number,name,last_name,email,username,account_number,password,phone,role,document_type)
            }catch (e:java.lang.Exception){
                println(e)
            }
        }


    }
    private fun goToRegister2(){
        val i = Intent(this,MainActivity::class.java)
        startActivity(i)
    }


}