package diana.paul.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import diana.paul.quiz.builder.PoolBuilder;
import diana.paul.quiz.globals.Globals;
import diana.paul.quiz.library.AnswerLibrary;
import diana.paul.quiz.library.QuestionLibrary;

public class QuizActivity extends AppCompatActivity {

    private Globals globals;

    private ArrayList<Question> mQuiz;

    private ArrayList<ArrayList<Answer>> mAns;

    private TextView mQuestion;

    private TextView mScoreView;

    private Question curQuestion;

    private ArrayList<Answer> curAnswers;

    private Button mChoice1;

    private Button mChoice2;

    private Button mChoice3;

    private Button mChoice4;

    private int round=0;

    private int score=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        init();
        startListners();
    }

    private void startListners(){
        mChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateScore(1);
            }
        });
        mChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateScore(2);
            }
        });
        mChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateScore(3);
            }
        });
        mChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateScore(4);
            }
        });

    }

    private void updateScore(int i){
        if(curQuestion.isCorrectAns(curAnswers.get(i))){
            score++;
        }
            round++;
        updateScreen();
    }

    private void updateScreen(){
        if(round<20){
            curQuestion = mQuiz.get(round);
            curAnswers = mAns.get(round);
            mScoreView.setText(score);
            mQuestion.setText(curQuestion.getText());
            mChoice1.setText(curAnswers.get(0).getAnswer());
            mChoice2.setText(curAnswers.get(1).getAnswer());
            mChoice3.setText(curAnswers.get(2).getAnswer());
            mChoice4.setText(curAnswers.get(3).getAnswer());
        }
        else{
            startNextActivity();
        }

    }

    private void startNextActivity(){
        globals.setScore(score);
        Intent intent= new Intent(this,NameActivity.class);
        startActivity(intent);
    }

    private void init(){
        globals=Globals.getInstance();
        QuestionLibrary mQuestions;
        AnswerLibrary mAnswers;
        PoolBuilder mPool= new PoolBuilder();
        mQuestion=findViewById(R.id.question);
        mScoreView=findViewById(R.id.score_text);
        mChoice1=findViewById(R.id.choice1);
        mChoice2=findViewById(R.id.choice2);
        mChoice3=findViewById(R.id.choice3);
        mChoice4=findViewById(R.id.choice4);
        mQuestions=new QuestionLibrary(mPool.getQuestionPool());
        mQuestions.setCategory(globals.getCategory());
        mQuiz= mQuestions.getQuestions();
        mAnswers= new AnswerLibrary(mPool.getAnswerPool(),mQuiz);
        mQuestions.setCategory(globals.getCategory());
        mAns=mAnswers.getAnswers();
        updateScreen();

    }
}
