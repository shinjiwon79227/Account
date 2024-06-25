package com.sjw.account

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val signInBtn = findViewById<Button>(R.id.in_sign_in_btn)
        val signUpBtn = findViewById<Button>(R.id.in_sign_up_btn)
        val id = findViewById<EditText>(R.id.in_input_id)
        val pw = findViewById<EditText>(R.id.in_input_pw)

        signInBtn.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            when {
                id.text.toString().isEmpty() ->
                    Toast.makeText(this, "아이디를 입력해주세요", Toast.LENGTH_SHORT).show()
                pw.text.toString().isEmpty() ->
                    Toast.makeText(this, "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show()
                else -> {
                    Toast.makeText(this, "로그인 성공!", Toast.LENGTH_SHORT).show()
                    intent.putExtra("id", id.toString())
                    startActivity(intent)
                }
            }
        }

        signUpBtn.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

    }
}