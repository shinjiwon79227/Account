package com.sjw.account

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class HomeActivity : AppCompatActivity() {
    val random = Random
    val nameData = arrayListOf("말하는 감자","못말리는 짱구","김밥 <<< 레어닉","돈까스","신지원")
    val ageData = arrayListOf("21","0","25","7","5")
    val mbtiData = arrayListOf("ISTP","ENFJ","INTJ","INFP","ENFP")
    val imgSrcData = arrayListOf(
        R.drawable.grizzly,
        R.drawable.panda,
        R.drawable.icebear
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val inputId = intent.getStringExtra("id")
        Log.d("data", "$inputId")

        val id = findViewById<TextView>(R.id.home_id)
        val name = findViewById<TextView>(R.id.home_name)
        val age = findViewById<TextView>(R.id.home_age)
        val mbti = findViewById<TextView>(R.id.home_MBTI)

        val img = findViewById<ImageView>(R.id.home_img)

        val finishBtn = findViewById<Button>(R.id.home_finish_btn)

        id.text = inputId
        name.text = nameData.get(random.nextInt(nameData.size))
        age.text = ageData.get(random.nextInt(ageData.size))
        mbti.text = mbtiData.get(random.nextInt(mbtiData.size))
        img.setImageResource(imgSrcData.get(random.nextInt(imgSrcData.size)))

        finishBtn.setOnClickListener { finish() }
    }
}