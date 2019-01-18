package diana.paul.quiz.library;

import java.util.*;
import diana.paul.quiz.Question;


public class QuestionLibrary {
    private String category;
    private ArrayList<Question> mQuestions;


    public QuestionLibrary(ArrayList<Question> q){
        mQuestions=q;
    }

    private ArrayList<Question> sortQuestion() {
        ArrayList<Question> sortedQuestions = new ArrayList<>();
        for (Question q : mQuestions) {
            if (q.isCategory(category)) {
                sortedQuestions.add(q);
            }
        }
        return sortedQuestions;
    }

    public ArrayList<Question> getQuestions(){
        ArrayList<Question> que= new ArrayList<>();
        ArrayList<Question> sortedQuestions=this.sortQuestion();
        int random;
        boolean flag=false;
        for(int i=0;i<20;i++){
                random=(int)Math.round(Math.random())*sortedQuestions.size();
                if(!que.contains(sortedQuestions.get(random))) {
                    que.add(sortedQuestions.get(random));
                }
                else
                    --i;
        }
        return que;
    }

    public void setCategory(String cat){
        category=cat;
    }
}
