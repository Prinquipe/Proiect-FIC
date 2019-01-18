package diana.paul.quiz.builder;

import java.util.ArrayList;
import java.util.Scanner;

import diana.paul.quiz.Answer;
import diana.paul.quiz.Question;
import diana.paul.quiz.data_write_read.AnswerFileStreamer;
import diana.paul.quiz.data_write_read.QuestionFileStreamer;

public class PoolBuilder {

    private ArrayList<Answer> answerPool;

    private ArrayList<Question> questionPool;

    private AnswerFileStreamer answerReader = AnswerFileStreamer.getAnswerFileStreamer();

    private QuestionFileStreamer questionReader = QuestionFileStreamer.getQuestionFileStreamer();


    public PoolBuilder(){
        answerPool=new ArrayList<>();
        questionPool=new ArrayList<>();
        initPools();
    }

    public ArrayList<Answer> getAnswerPool(){

        return answerPool;
    }

    public ArrayList<Question> getQuestionPool(){

        return questionPool;
    }
    private void initPools(){
        String buffer;
        String temp;
        Question question;
        Answer answer;
        Scanner parser;
        int i;

        while((buffer=answerReader.readFromAnswerFile())!=null){
            parser= new Scanner(buffer);
            answer = new Answer();
            parser.useDelimiter(":");
            temp = parser.next();
            answer.setCategory(temp);
            temp= parser.next();
            answer.setAnswer(temp);
            answerPool.add(answer);
        }
        while((buffer=questionReader.readFromQuestionFile())!=null){
            parser= new Scanner(buffer);
            question = new Question();
            parser.useDelimiter(":");
            temp = parser.next();
            question.setCategory(temp);
            temp = parser.next();
            question.setText(temp);
             i = parser.nextInt();
            question.setCorrectAnswer(i);
            questionPool.add(question);
        }
    }
}
