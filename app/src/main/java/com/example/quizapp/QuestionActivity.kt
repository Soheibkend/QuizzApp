package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var currentQuestionIndex : Int = 1
    private lateinit var questionList: ArrayList<Question>
    private  var selectedOption:Int = 0
    private var correctAnswerNumber = 0
    private var userName : String?  = null

    private fun setQuestion () {
        val currentQuestion : Question = questionList.get(currentQuestionIndex-1)

        defaultOptionViews()

        if (currentQuestionIndex == questionList.size) {
            val submitButton : Button = findViewById(R.id.submit_button)
            submitButton.text = "FINISH"
        } else {
            val submitButton : Button = findViewById(R.id.submit_button)
            submitButton.text = "SUBMIT"
        }

        val progressBar : ProgressBar = findViewById(R.id.progress_bar)
        progressBar.setProgress(currentQuestionIndex)

        val progressTextView : TextView = findViewById(R.id.progress_text_view)
        progressTextView.text = "${currentQuestionIndex}/${progressBar.max}"

        val flagImageView : ImageView = findViewById(R.id.flag_image_view)
        flagImageView.setImageResource(currentQuestion.image)

        val option1TextView : TextView = findViewById(R.id.option1_text_view)
        option1TextView.text = currentQuestion.option1

        val option2TextView : TextView = findViewById(R.id.option2_text_view)
        option2TextView.text = currentQuestion.option2

        val option3TextView : TextView = findViewById(R.id.option3_text_view)
        option3TextView.text = currentQuestion.option3


        val option4TextView : TextView = findViewById(R.id.option4_text_view)
        option4TextView.text = currentQuestion.option4

        val submitButton : Button = findViewById(R.id.submit_button)
        submitButton.text = "SUBMIT"
    }


    private fun defaultOptionViews () {

        val option1TextView : TextView = findViewById(R.id.option1_text_view)
        val option2TextView : TextView = findViewById(R.id.option2_text_view)
        val option3TextView : TextView = findViewById(R.id.option3_text_view)
        val option4TextView : TextView = findViewById(R.id.option4_text_view)


        val textViews = ArrayList<TextView>()
        textViews.add(0,option1TextView)
        textViews.add(1,option2TextView)
        textViews.add(2,option3TextView)
        textViews.add(3,option4TextView)

        for (textView in textViews) {
            textView.setTextColor(Color.parseColor("#7A8089"))
            textView.typeface = Typeface.DEFAULT
            textView.background = ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        userName = intent.getStringExtra(Constants.USER_NAME)

        questionList = Constants.getQuestions()

        setQuestion()

        val option1TextView : TextView = findViewById(R.id.option1_text_view)
        val option2TextView : TextView = findViewById(R.id.option2_text_view)
        val option3TextView : TextView = findViewById(R.id.option3_text_view)
        val option4TextView : TextView = findViewById(R.id.option4_text_view)
        val submitButton : Button = findViewById(R.id.submit_button)

        option1TextView.setOnClickListener(this)
        option2TextView.setOnClickListener(this)
        option3TextView.setOnClickListener(this)
        option4TextView.setOnClickListener(this)
        submitButton.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.option1_text_view -> {
                val option1TextView : TextView = findViewById(R.id.option1_text_view)

                selectedOption(option1TextView,1)}
            R.id.option2_text_view -> {
                val option2TextView : TextView = findViewById(R.id.option2_text_view)

                selectedOption(option2TextView,2)
            }
            R.id.option3_text_view -> {
                val option3TextView : TextView = findViewById(R.id.option3_text_view)

                selectedOption(option3TextView,3)
            }
            R.id.option4_text_view -> {
                val option4TextView : TextView = findViewById(R.id.option4_text_view)

                selectedOption(option4TextView,4)
            }
            R.id.submit_button -> {
                if (selectedOption == 0) {
                    currentQuestionIndex++

                    when {
                        currentQuestionIndex <= questionList.size -> {
                            setQuestion()
                        } else -> {
                            val intent : Intent = Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, userName)
                            intent.putExtra(Constants.CORRECT_ANSWER, correctAnswerNumber)
                            intent.putExtra(Constants.TOTAL_QUESTION,questionList.size)
                            startActivity(intent)
                        }
                    }
                } else {
                    val question = questionList.get(currentQuestionIndex - 1)
                    if (question.answer != selectedOption) {
                        answerView(selectedOption, R.drawable.wrong_option_border)
                    } else {
                        correctAnswerNumber++
                    }
                    answerView(question.answer,R.drawable.correct_option_border)

                    if (currentQuestionIndex == questionList.size) {
                        val submitButton : Button = findViewById(R.id.submit_button)
                        submitButton.text = "FINISH"
                    } else {
                        val submitButton : Button = findViewById(R.id.submit_button)
                        submitButton.text = "GO TO NEXT QUESTION"
                    }

                    selectedOption = 0
                }
            }
        }
    }

    private fun answerView (answer:Int , drawableView:Int) {
        when (answer) {
            1 -> {
                val option1TextView : TextView = findViewById(R.id.option1_text_view)
                option1TextView.background = ContextCompat.getDrawable(this,drawableView)
            }

            2 -> {
                val option2TextView : TextView = findViewById(R.id.option2_text_view)
                option2TextView.background = ContextCompat.getDrawable(this,drawableView)
            }

            3 -> {
                val option3TextView : TextView = findViewById(R.id.option3_text_view)
                option3TextView.background = ContextCompat.getDrawable(this,drawableView)
            }

            4 -> {
                val option4TextView : TextView = findViewById(R.id.option4_text_view)
                option4TextView.background = ContextCompat.getDrawable(this,drawableView)
            }
        }
    }



    private fun selectedOption (textView: TextView, option:Int) {
        defaultOptionViews()
        selectedOption = option

        textView.setTextColor(Color.parseColor("#363A43"))
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(this,R.drawable.selected_option_border)
    }
}