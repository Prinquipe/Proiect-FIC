package diana.paul.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static String cat=null;

    private Button Cat1;

    private Button Cat2;

    private Button Cat3;

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        Cat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCat("Istorie");
                openQuiz();
            }
        });
        Cat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCat("Programare");
                openQuiz();
            }
        });
        Cat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCat("Trivia");
                openQuiz();
            }
        });
    }

    public void openQuiz(){
        Intent intent= new Intent(this,QuizActivity.class);
        startActivity(intent);
    }

    private static void setCat(String s){
        cat=s;
    }
    public static String getCat(){
        return cat;
    }
    private void init(){
        Cat1=findViewById(R.id.cat1);
        Cat2=findViewById(R.id.cat2);
        Cat3=findViewById(R.id.cat3);
        text=findViewById(R.id.text1);
    }
}
