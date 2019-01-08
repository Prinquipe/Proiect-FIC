package diana.paul.quiz.library;

import java.util.*;
import diana.paul.quiz.Question;


public class QuestionLibrary {
    private String category;
    private ArrayList<Question> mQuestions;


    public QuestionLibrary(ArrayList<Question> q){
        mQuestions=q;
    }

    public ArrayList<Question> sortQuestion() {
        ArrayList<Question> sortedQuestions = new ArrayList<>();
        for (Question q : mQuestions) {
            if (q.isOfCategory(category)) {
                sortedQuestions.add(q);
            }
            return sortedQuestions;
        }
    }

    public Question[] getQuestions(){
        Question[] que= new Question[20];
        int counter=0;
        Question question;
        ArrayList<Question> sortedQuestions=this.sortQuestion(category);
        int random;
        boolean flag=false;
        for(int i=0;i<20;i++){
            while(!flag){
                random = (int)Math.random() * sortedQuestions.size();
                question = sortedQuestions.get(random);
                for(int j=0;j<counter;j++){
                    if(!question.equals(que[j])){
                        que[counter]=question;
                        ++counter;
                        flag=true;
                    }
                }
            }
            flag=false;
        }
        return quee;
    }

    public void setCategory(String cat){
        category=cat;
    }
}
