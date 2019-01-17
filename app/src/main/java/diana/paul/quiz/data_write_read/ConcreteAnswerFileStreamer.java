package diana.paul.quiz.data_write_read;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConcreteAnswerFileStreamer extends AnswerFileStreamer{

    private BufferedWriter answerWriter;

    private BufferedReader answerReader;

    private static ConcreteAnswerFileStreamer _instance=null;

    private ConcreteAnswerFileStreamer(){
        FileReader aux;
        FileWriter aux2;

        try {
            aux=new FileReader("Answers.txt");
            answerReader= new BufferedReader(aux);
        } catch(FileNotFoundException e) {
            System.out.println("Problems with answerReader.File does not exist");
        }
        try {
            aux2=new FileWriter("Answers.txt");
            answerWriter= new BufferedWriter(aux2);
        } catch(IOException e) {
            System.out.println("Problems with answerWriter");
        }
    }



    public boolean writeInAnswerFile(String text){
        boolean res=true;
        try {
            answerWriter.write(text, 0, text.length());
        }catch(IOException e){
            System.out.println("Error while trying to write in Answer File");
            res=false;
        }

        return res;
    }

    public String readFromAnswerFile(){
        String asset=null;
        try{
            asset=answerReader.readLine();
        }catch(IOException e){
            System.out.println("Error while trying to read from the Answer File");
        }

        return asset;
    }


    static AnswerFileStreamer getConcreteAnswerFileStreamer(){
        if(_instance==null)
            _instance= new ConcreteAnswerFileStreamer();
        return _instance;

    }
}
