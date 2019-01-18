
package diana.paul.quiz.library;
import diana.paul.quiz.Answer;
import diana.paul.quiz.Question;
import java.util.ArrayList;


public class AnswerLibrary {

    private ArrayList<Answer> mAnswers;
    private ArrayList<Question> questions;

    public AnswerLibrary(ArrayList<Answer> ans, ArrayList<Question> que){
        questions=que;
        mAnswers=ans;
    }

    public ArrayList<ArrayList<Answer>> getAnswers(){
        ArrayList<Answer> ansPool=this.sortAnswers();
        ArrayList<Answer> shuffle=new ArrayList<>();
        int aux;
        ArrayList<ArrayList<Answer>> mapper=new ArrayList<>();
        for(Question q: questions){
            shuffle.add(ansPool.get(q.getCorrectAnswer()));
            for(int i=0;i<3;i++){
                aux=(int)Math.round(Math.random())*ansPool.size();
                if(!shuffle.contains(ansPool.get(aux))) {
                    shuffle.add(ansPool.get(aux));
                }
                else
                    --i;
            }
            shuffle=this.shuffleAlg(shuffle);
            mapper.add(shuffle);
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

    private ArrayList<Answer> shuffleAlg(ArrayList<Answer> a){
        ArrayList<Answer> newArray= new ArrayList<>();
        int aux;
        for(int i=0;i<4;i++){
            aux=(int)Math.round(Math.random())*a.size();
            if(!newArray.contains(a.get(aux))){
                newArray.add(a.get(aux));
            }
            else{
                --i;
            }
        }
        return newArray;
    }
}

