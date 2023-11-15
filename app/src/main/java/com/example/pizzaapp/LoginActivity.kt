package com.example.pizzaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //hide title bar
        getSupportActionBar()?.hide()

        //instance text

        val txtUsername:EditText = findViewById(R.id.editTextEmail)
        val txtPassword:EditText = findViewById(R.id.editTextPassword)
        //instance button login
        val btnLogin:Button = findViewById(R.id.buttonLogin)
        val buatAkun : TextView = findViewById(R.id.buatAkun)


        //event button login
        btnLogin.setOnClickListener {
            val databaseHelper = DatabaseHelper(this)

           //val data:String = databaseHelper.checkData("stevi.ema@amikom.ac.id")
            //Toast.makeText(this@LoginActivity,"Result: " + data,
            //Toast.LENGTH_SHORT).show()
            //if(data == null){
                databaseHelper.addAccount("stevi.ema@amikom.ac.id","Stevi Ema W","Cashier","12345")
            //}
            val email = txtUsername.text.toString().trim()
            val password = txtPassword.text.toString().trim()

            val result:Boolean = databaseHelper.checkLogin(email,password)
            if(result == true){
                Toast.makeText(this@LoginActivity,"LOGIN SUKSES",Toast.LENGTH_SHORT).show()
                val intentLogin = Intent(this@LoginActivity,MainActivity::class.java)
                startActivity(intentLogin)
            }else{
                Toast.makeText(this@LoginActivity,"LOGIN gagallll",Toast.LENGTH_SHORT).show()
            }

        }

        buatAkun.setOnClickListener{
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}