package diana.paul.quiz.data_write_read;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConcreteQuestionFileStreamer extends QuestionFileStreamer{

    private BufferedWriter questionWriter;

    private BufferedReader questionReader;


    private static ConcreteQuestionFileStreamer _instance=null;

    private ConcreteQuestionFileStreamer(){
        FileReader aux;
        FileWriter aux2;
        try {
            aux=new FileReader("Questions.txt");
            questionReader=new BufferedReader(aux);
            } catch(FileNotFoundException e) {
            System.out.println("Problems with questionReader.File does not exist");
        }
        try {
            aux2=new FileWriter("Questions.txt");
            questionWriter=new BufferedWriter(aux2);
        } catch(IOException e) {
            System.out.println("Problems with questionWriter");
        }
    }

    public boolean writeInQuestionFile(String text){
            boolean res=true;
            try {
                questionWriter.write(text, 0, text.length());
            }catch(IOException e){
                System.out.println("Error while trying to write in Question File");
                res=false;
            }

            return res;
        }

        public String readFromQuestionFile(){
            String asset=null;
            try{
                asset=questionReader.readLine();
            }catch(IOException e){
                System.out.println("Error while trying to read from the Question File");
            }

        return asset;
    }


    static QuestionFileStreamer getConcreteQuestionFileStreamer(){
        if(_instance==null)
            _instance= new ConcreteQuestionFileStreamer();
        return _instance;

    }
}
