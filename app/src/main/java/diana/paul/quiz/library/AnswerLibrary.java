
package diana.paul.quiz.library;
import diana.paul.quiz.Answer;
import diana.paul.quiz.Question;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

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
        ArrayList<ArrayList<Answer>> mapper=new ArrayList<ArrayList<Answer>>();
        for(Question q: questions){

        }
        return mapper;
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

