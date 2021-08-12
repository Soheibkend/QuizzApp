package com.example.quizapp

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTION :String = "total_question"
    const val CORRECT_ANSWER : String = "correct_answer"

    fun getQuestions (): ArrayList<Question> {
        val questions = ArrayList<Question> ()
        val quest1 = Question (
                1,
                "What country does this flag belong to ?",
                 R.drawable.ic_flag_of_argentina,
                "Argentina",
                "brazil",
                "australia",
                "kuwait",
                1
                )

        val quest2 = Question (
                2,
                "What country does this flag belong to ?",
                R.drawable.ic_flag_of_kuwait,
                "india",
                "brazil",
                "fiji",
                "kuwait",
                4
        )

        val quest3 = Question (
                3,
                "What country does this flag belong to ?",
                R.drawable.ic_flag_of_india,
                "india",
                "denmark",
                "fiji",
                "new zealand",
                1
        )

        val quest4 = Question (
                4,
                "What country does this flag belong to ?",
                R.drawable.ic_flag_of_denmark,
                "new zealand",
                "brazil",
                "fiji",
                "denmark",
                4
        )

        val quest5 = Question (
                5,
                "What country does this flag belong to ?",
                R.drawable.ic_flag_of_belgium,
                "belgium",
                "brazil",
                "fiji",
                "australia",
                1
        )

        val quest6 = Question (
                6,
                "What country does this flag belong to ?",
                R.drawable.ic_flag_of_new_zealand,
                "australia",
                "france",
                "fiji",
                "new zealand",
                4
        )

        val quest7 = Question (
                7,
                "What country does this flag belong to ?",
                R.drawable.ic_flag_of_fiji,
                "india",
                "brazil",
                "fiji",
                "germany",3
        )

        val quest8 = Question (
                8,
                "What country does this flag belong to ?",
                R.drawable.ic_flag_of_germany,
                "australia",
                "belgium",
                "fiji",
                "germany",
                4
        )


        val quest9 = Question (
                9,
                "What country does this flag belong to ?",
                R.drawable.ic_flag_of_brazil,
                "india",
                "brazil",
                "fiji",
                "argentina",
                2
        )

        val quest10 = Question (
                10,
                "What country does this flag belong to ?",
                R.drawable.ic_flag_of_australia,
                "india",
                "new zealand",
                "fiji",
                "australia",
                4
        )

        questions.add(quest1)
        questions.add(quest2)
        questions.add(quest3)
        questions.add(quest4)
        questions.add(quest5)
        questions.add(quest6)
        questions.add(quest7)
        questions.add(quest8)
        questions.add(quest9)
        questions.add(quest10)


        return questions


    }
}