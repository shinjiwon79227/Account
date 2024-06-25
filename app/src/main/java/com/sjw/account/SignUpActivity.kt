package com.sjw.account

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val name = findViewById<EditText>(R.id.up_input_name)
        val id = findViewById<EditText>(R.id.up_input_id)
        val pw = findViewById<EditText>(R.id.up_input_pw)

        val signUpBtn = findViewById<Button>(R.id.up_sign_up_btn)

        signUpBtn.setOnClickListener {
            when {
                name.text.toString().isEmpty() || id.text.toString().isEmpty() || pw.text.toString().isEmpty() ->
                    Toast.makeText(this, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
                else -> {
                    Toast.makeText(this, "회원가입 성공!\n당신은 이제 김밥 월드 회원~", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
    }
}