package com.example.gp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val Sign_RequestCode = 1
    private lateinit var sign: Button
    private lateinit var login: Button
    private lateinit var name: EditText
    private lateinit var psw: EditText
    private var _name: String? = null
    private var _psw: String? = null

    private lateinit var scanQRCode: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sign = findViewById(R.id.sign)
        login = findViewById(R.id.login)
        name = findViewById(R.id.name)
        psw = findViewById(R.id.psw)

        sign.setOnClickListener {
            val intent = Intent(this, Sign::class.java)
            startActivityForResult(intent, Sign_RequestCode)
        }

        login.setOnClickListener {
            val inputName = name.text.toString()
            val inputPsw = psw.text.toString()

            if (_name != null && _psw != null && inputName == _name && inputPsw == _psw) {
                Toast.makeText(this, "log successfully", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, home_page::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "wrong username or password", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Sign_RequestCode && resultCode == RESULT_OK && data != null) {
            _name = data.getStringExtra("name")
            _psw = data.getStringExtra("psw")
        }
    }
}
