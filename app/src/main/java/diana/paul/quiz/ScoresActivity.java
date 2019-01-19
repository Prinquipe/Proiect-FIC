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

        import java.util.ArrayList;

        import diana.paul.quiz.globals.Globals;

public class ScoresActivity extends AppCompatActivity {

    private Globals globals;

    private WriteTopScores tops;

    private TextView text1;

    private TextView text2;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
        init();
        text2.setText(prepareString());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retry();
            }
        });
    }

    private void retry(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    private void init() {
        button=findViewById(R.id.again);
        text1 = findViewById(R.id.top_score);
        text2 = findViewById(R.id.scorelist);
        tops = new WriteTopScores();
        globals=Globals.getInstance();
        tops.setCategory(globals.getCategory());
        tops.readTopScores();
    }

    private String prepareString(){
        ArrayList<String> aux=tops.getName();
        ArrayList<Integer> aux2=tops.getScore();
        String buffer="";
        int j;
        for(int i=0;i<aux.size();i++)
        {
            j=i+1;
            buffer=buffer+j+". "+aux.get(i)+" "+aux2.get(i)+"\n";
        }
        return buffer;
    }
}
