package diana.paul.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import diana.paul.quiz.data_write_read.TopFileStreamer;

public class WriteTopScores {

    private String category;

    private TopFileStreamer tops;

    private ArrayList<String> name;

    private ArrayList<Integer> score;

    public WriteTopScores(){
        name= new ArrayList<>();
        tops=TopFileStreamer.getTopFileStreamer();
        score=new ArrayList<>();
    }

    public void setCategory(String s){
        category=s;
        readTopScores();;
    }

    public void readTopScores(){
        String buff;
        String aux;
        Scanner s;
        int i;
        ArrayList<String> buffer=new ArrayList<>();
        ArrayList<Integer> intBuffer= new ArrayList<>();
        while((buff=tops.readFromTopFile())!=null){
            s=new Scanner(buff);
            s.useDelimiter(":");
            if(s.next()==category){
                aux=s.next();
                buffer.add(aux);
                i=s.nextInt();
                intBuffer.add(i);
            }
        }
        sort(buffer,intBuffer);

        for(i=0;i<10;i++) {
            name.add(buffer.get(i));
            score.add(intBuffer.get(i));
        }
    }

    public void writeToTopScores(String s,int i){
                boolean res;
                String aux=category+":"+s+":"+i;
                res=tops.writeInTopFile(aux);
                if(res) {
                    System.out.println("Sucessfully written in file");
                }
                else {
                    System.out.println("Error at write in file");
                }
    }

    public ArrayList<String> getName(){
        return name;
    }

    public ArrayList<Integer> getScore(){
        return score;
    }

    private void sort(ArrayList<String> s,ArrayList<Integer> Int){
        String aux;
        int aux2;
        for(int i=0;i<Int.size();i++){
            for(int j=0;j<Int.size();j++){
                if (Int.get(i)<Int.get(j)){
                    aux2=Int.get(i);
                    Int.set(i,Int.get(j));
                    Int.set(j,aux2);
                    aux=s.get(i);
                    s.set(i,s.get(j));
                    s.set(j,aux);
                }
                }
            }
        }
}
