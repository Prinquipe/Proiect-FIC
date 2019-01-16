package diana.paul.quiz.data_write_read;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConcreteTopFileStreamer extends TopFileStreamer{

    private BufferedWriter topWriter;

    private BufferedReader topReader;

    private static ConcreteTopFileStreamer _instance=null;

    private ConcreteTopFileStreamer(){
        FileReader aux;
        FileWriter aux2;

        try {
            aux=new FileReader("Top.txt");
            topReader= new BufferedReader(aux);
        } catch(FileNotFoundException e) {
            System.out.println("Problems with answerReader.File does not exist");
        }
        try {
            aux2=new FileWriter("Top.txt");
            topWriter= new BufferedWriter(aux2);
        } catch(IOException e) {
            System.out.println("Problems with answerWriter");
        }
    }


    public boolean writeInTopFile(String text){
        boolean res=true;
        try {
            topWriter.write(text, 0, text.length());
        }catch(IOException e){
            System.out.println("Error while trying to write in Top File");
            res=false;
        }

        return res;
    }

    public String readFromTopFile(){
        String asset=null;
        try{
            asset=topReader.readLine();
        }catch(IOException e){
            System.out.println("Error while trying to read from the Top File");
        }

        return asset;
    }

    static TopFileStreamer getConcreteTopFileStreamer(){
        if(_instance==null)
            _instance= new ConcreteTopFileStreamer();
        return _instance;

    }
}
