package com.example.bmiproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weightEditText = findViewById<EditText>(R.id.weightEditText)
        val heightEditText = findViewById<EditText>(R.id.heightEditText)
        val resultButton = findViewById<AppCompatButton>(R.id.resultButton)

        resultButton.setOnClickListener {

            if (weightEditText.text.isEmpty() || heightEditText.text.isEmpty()){
                Toast.makeText(this, "빈 값이 있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //EditText값 가져와서 정수형으로 변환
            val weight = weightEditText.text.toString().toInt()
            val height = heightEditText.text.toString().toInt()

            val intent = Intent(this, ResultActivity::class.java)

            //Intent로 넘어갈 때 해당 이름의 값들도 같이 넘겨준다.
            intent.putExtra("weight", weight)
            intent.putExtra("height", height)

            startActivity(intent)

        }
    }
}