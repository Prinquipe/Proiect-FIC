package diana.paul.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import diana.paul.quiz.globals.Globals;

public class NameActivity extends AppCompatActivity {

    private Globals globals;

    private WriteTopScores writer;

    String name;
    EditText nameInput;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        init();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameInput.getText().toString();
                writer.writeToTopScores(name, globals.getScore());

                startNextActivity();
            }
        });
    }

        private void startNextActivity(){
            Intent intent=new Intent(this,ScoresActivity.class);
            startActivity(intent);
        }


    private void init(){
        globals=Globals.getInstance();

        nameInput = (EditText)findViewById(R.id.nameInput);

        submitButton = (Button)findViewById(R.id.submitButton);

        writer=new WriteTopScores();

        writer.setCategory(globals.getCategory());

    }

    public String getName(){
        return name;
    }
}
