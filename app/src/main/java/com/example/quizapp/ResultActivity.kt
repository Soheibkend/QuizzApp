package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val userName = intent.getStringExtra(Constants.USER_NAME)
        val userTextView : TextView = findViewById(R.id.username_text_view)
        userTextView.text = userName

        val totalQuest = intent.getStringExtra(Constants.TOTAL_QUESTION)
        val correctAnswer = intent.getStringExtra(Constants.CORRECT_ANSWER)

        val resultTextView : TextView = findViewById(R.id.result_text_view)
        resultTextView.text = "Your score is " + correctAnswer + " out of " + totalQuest

        val finishButton : Button = findViewById(R.id.finish_button)
        finishButton.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        })
    }
}