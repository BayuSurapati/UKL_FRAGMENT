package com.bayusurapati.projectukl1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnLogin:Button
    private lateinit var btnRegister:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin=findViewById(R.id.btnLogin_activity)
        btnLogin.setOnClickListener(this)

        btnRegister=btnRegister_activity
        btnRegister.setOnClickListener(this)


    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnLogin_activity -> {
                btnLogin.setOnClickListener {
                    val inputEmail = findViewById<EditText>(R.id.editTextEmail).text.toString()
                    val inputPassword = findViewById<EditText>(R.id.editTextNumber).text.toString()

                    Intent(this, Login::class.java).also {
                        it.putExtra("EXTRA_EMAIL", inputEmail)
                        val inputEmail = editTextEmail.text.toString()
                        val inputPassword = editTextNumber.text.toString()

                        if(inputEmail.isEmpty()){
                            editTextEmail.setError("Masukkan Email Anda")
                        }else if(inputPassword.isEmpty()){
                            editTextNumber.setError("Masukkan Password Anda")
                        }else{
                            startActivity(it)
                        }
                    }
                }
            }
            R.id.btnRegister_activity->{
                val moveIntentRegister = Intent(this@MainActivity, RegistActivity::class.java)
                startActivity(moveIntentRegister)
            }
        }
    }
}