package com.example.pizzaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.provider.ContactsContract.Intents
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val txtEmail: EditText = findViewById(R.id.registerEmail)
        val txtName : EditText = findViewById(R.id.registerPersonName)
        val txtLevel : EditText = findViewById(R.id.registerLevel)
        val txtPassword : EditText = findViewById(R.id.registerPassword)

        val btnRegister : Button = findViewById(R.id.buttonRegisterAccount)

        btnRegister.setOnClickListener{
            val databaseHelper = DatabaseHelper(this)

            val email : String = txtEmail.text.toString().trim()
            val name : String = txtName.text.toString().trim()
            val level :String = txtLevel.text.toString().trim()
            val password: String = txtPassword.text.toString().trim()

            val data:String = databaseHelper.checkData(email)

            if(data !=  null){
                databaseHelper.addAccount(
                    email,name,level,password
                )

                val intentLogin = Intent(this@RegisterActivity,LoginActivity::class.java)
                startActivity(intentLogin)
            }else{
                Toast.makeText(this@RegisterActivity,"Register gagal" +
                "Email sudah terdaftar",Toast.LENGTH_SHORT).show()
            }
        }
    }
}