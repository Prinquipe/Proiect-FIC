
package diana.paul.quiz.library;
import diana.paul.quiz.Answer;
import diana.paul.quiz.Question;
import java.util.ArrayList;
import java.util.Map;

public class AnswerLibrary {

    private ArrayList<Answer> mAnswers;
    private ArrayList<Question> questions;

    public AnswerLibrary(ArrayList<Answer> ans, ArrayList<Question> que){
        questions=que;
        mAnswers=ans;
    }

    public ArrayList<ArrayList<Answer>> getAnswers(){
        ArrayList<Answer> ansPool=this.sortAnswers();
        ArrayList<Answer> shuffle= new ArrayList<>();

        <ArrayList<Answer>> ansMap= ArrayList<ArrayList>();

        for(Answer a: ansPool){
            for(Question q: questions){

            }
        }
    }

    private ArrayList<Answer> sortAnswers(){
        ArrayList<Answer> sortedAnswer=new ArrayList<>();
        for(Answer a :mAnswers) {
            if (a.isOfCategory(questions.get(0).getCategory())) {
                sortedAnswer.add(a);
            }
        }
        return sortedAnswer;
    }
}

