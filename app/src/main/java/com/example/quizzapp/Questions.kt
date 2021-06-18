package com.example.quizzapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ListView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.google.gson.GsonBuilder
import java.lang.Math.abs

class Questions : AppCompatActivity() {


    companion object{
        val allJoined: ArrayList<JoinedFeed> = ArrayList();//what is this ?
        var selectedAnswer: ArrayList<String> = ArrayList();
        var questionNr: Int = 0;
        var isCorrect: Int = 0;
        var isFailed: Int = 0;
        var flag=0;
        var num =0;
        //var sum=0;

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
      if(flag==1) reset()
        val intent = intent

        num++;
        intent.putExtra("num",num.toString());
        val name1 = intent.getStringExtra("name")

//        var x:Int = 0
//       if(name1 !=null) x=1;
//        if(name2 !=null) x=2;
//        if(name3 !=null) x=3;
//        when(x)

        var endpoint: String ="init"

//5 film 6 history 7 mussic

        if (name1 == "a") endpoint = "https://opentdb.com/api.php?amount=10&category=11&difficulty=easy&type=multiple";
        if (name1 == "b") endpoint = "https://opentdb.com/api.php?amount=10&category=23&difficulty=easy&type=multiple";
        if (name1 == "c") endpoint = "https://opentdb.com/api.php?amount=10&category=12&difficulty=easy&type=multiple";
        if (name1 == "d") endpoint = "https://opentdb.com/api.php?amount=10&category=27&difficulty=easy&type=multiple";
        if (name1 == "e") endpoint = "https://opentdb.com/api.php?amount=10&category=28&difficulty=easy&type=multiple";//vehicles

        val questions: ArrayList<String> = ArrayList();
        val allanswers: ArrayList<ArrayList<String>> = ArrayList();
        val allcorrectanswer: ArrayList<String> = ArrayList();

        val donelayout: ConstraintLayout = findViewById(R.id.done);
        donelayout.visibility = View.GONE
        supportActionBar?.hide();

        val httpAsync = endpoint.httpGet()
            .responseString { request, response, result ->
                when (result) {
                    is com.github.kittinunf.result.Result.Failure -> {
                        val ex = result.getException()
                        println(ex)
                    }
                    is Result.Success -> {
                        val data: String = result.get()
                        val gson = GsonBuilder().create()

                        val mainData: AllResults = gson.fromJson(data, AllResults::class.java)
                        for ((index, value) in mainData.results.withIndex()) {

                            val mainFeed = mainData.results;//nguyen day json
                            val question = mainFeed[index].question;
                            questions.add(question)

                            val answers = mainFeed[index].incorrect_answers//add wrong answer
                            answers.add((0..3).random(), mainFeed[index].correct_answer);//3 wrong 1 right
                            allanswers.add(answers);

                            val canswers = mainFeed[index].correct_answer;
                            allcorrectanswer.add(canswers);
                        }
                    }
                }
            }

        httpAsync.join()

        allJoined.add(
            JoinedFeed(
                questions = questions,
                answers = allanswers,
                correct_answers = allcorrectanswer
            )
        )
        startQuiz()
        flag=1
        //reset()


    }

    private fun startQuiz() {
        val nextbtn = findViewById<ImageButton>(R.id.next_btn);
        val totalnum: TextView = findViewById<TextView>(R.id.total_num);
        val mainquestion: TextView = findViewById<TextView>(R.id.main_question);
        val donelayout: ConstraintLayout = findViewById(R.id.done);
        val quizlayout: ConstraintLayout = findViewById(R.id.quiz);
        val donepop: ListView = findViewById(R.id.done_pop);


        // Display Number
        var questionNum = questionNr;

        // Get current Question
        val currentQuestion = allJoined[0].questions[questionNr];

        // Grab the listview
        val answerListView: ListView = findViewById(R.id.answers_container);

        // Increase the Display number to +1
        questionNum++;
        totalnum.text = "${questionNum.toString()}/${allJoined[0].questions.count()}";


        // Set the first Question
        mainquestion.text = currentQuestion;

        // Set the first Question Answers
        var qanswers: ArrayList<String> = allJoined[0].answers[questionNr];
        setAnswers(qanswers)

        answerListView.setOnItemClickListener { parent, view, position, id ->
            val clickedID = id.toInt()
            val correctanswer = allJoined[0].correct_answers[questionNr]
            val selectedanswer = allJoined[0].answers[questionNr][clickedID]
            val answerIsCorrect = selectedanswer == correctanswer;

            // Check if answer is correct
            if (answerIsCorrect) {
                isCorrect++
            } else {
                isFailed--
            }
            if(questionNr == allJoined[0].questions.count() -1 && questionNum === 10){
                quizlayout.visibility = View.GONE;
                donelayout.visibility= View.VISIBLE
                //when we reach to the last question,we should stop moving to next because it can crash

                val qNumbers = "${allJoined[0].questions.count()}"
                val qCorrectAnswers = "${isCorrect}"//5 or 6
                val qAttempted = "${10}"//question dont skip
                val qNegative = "${abs(isFailed)}"//the number of wrong
                val score = "${10*isCorrect}"

                //val nextBtn = findViewById<ImageButton>(R.id.next_btn);
                //nextBtn.setOnClickListener {
                val intent = Intent(this,Score::class.java )




                    intent.putExtra("qNumbers", qNumbers.toString());
                    intent.putExtra("qCorrectAnswers", qCorrectAnswers.toString());
                    intent.putExtra("qAttempted", qAttempted.toString());
                    intent.putExtra("qNegative", qNegative.toString());
                    intent.putExtra("Score", score.toString());

                intent.putExtra("score", score);



                startActivity(intent);


                //startService(intent)

                //AppCompatActivity().finish();
                //donepop.adapter = DoneAdapter(this, info)//update the value


            }else{
                questionNum++;
                questionNr++
            }



            totalnum.text = "${questionNum.toString()}/${allJoined[0].questions.count()}"
            mainquestion.text = allJoined[0].questions[questionNr];


            //update answers
            val newAnswers = allJoined[0].answers[questionNr];
            setAnswers(newAnswers)



        }

        fun multiply(x: Int, y: Int) = x * y
    }

    private fun setAnswers(qanswers: ArrayList<String>) {
        val answers: ListView = findViewById(R.id.answers_container);
        for ((index, value) in qanswers.withIndex()) {
            answers.adapter = AnswerAdapter(this, qanswers)
        }
    }
    private fun reset()
    {
        allJoined.clear();
        selectedAnswer.clear();
        questionNr = 0;
        isCorrect = 0;
        isFailed = 0;
    }
}


