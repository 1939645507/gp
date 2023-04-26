package com.example.gp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Sign : AppCompatActivity() {
    private lateinit var back: Button
    private lateinit var submit: Button
    private lateinit var name: EditText
    private lateinit var psw: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)

        back = findViewById(R.id.back)
        submit = findViewById(R.id.submit)
        name = findViewById(R.id.sign_name)
        psw = findViewById(R.id.sign_psw)

        submit.setOnClickListener {
            Toast.makeText(this, "submit successfully", Toast.LENGTH_SHORT).show()
        }

        back.setOnClickListener {
            val intent = Intent().apply {
                putExtra("name", name.text.toString())
                putExtra("psw", psw.text.toString())
            }

            Toast.makeText(this, name.text.toString(), Toast.LENGTH_SHORT).show()
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}
