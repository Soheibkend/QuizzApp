package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val startButton:Button  = findViewById(R.id.start_button)
        startButton.setOnClickListener(View.OnClickListener {
            val nameEditText : EditText = findViewById(R.id.name_edit_text)

            if (nameEditText.text.toString().isEmpty()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent (this,QuestionActivity::class.java)
                intent.putExtra(Constants.USER_NAME, nameEditText.text.toString())
                startActivity(intent)
                finish()
            }
        })
    }
}