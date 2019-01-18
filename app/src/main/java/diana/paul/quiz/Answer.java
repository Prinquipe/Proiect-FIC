package diana.paul.quiz;

public class Answer {
    private int index;
    private String answer;
    private String category;

    private static int _count=0;

    public Answer(){
        index=_count;
        _count++;
    }

    public void setCategory(String s){
        category=s;
    }


    public void setAnswer(String text){
        answer=text;
    }

    String getAnswer(){
        return answer;
    }

    int getIndex(){
        return index;
    }

    public boolean isOfCategory(String c){
        if(c.equals(category))
            return true;
        return false;
    }

    public boolean equals(Object obj){
        if(obj instanceof Answer){
            if(((Answer)obj).getIndex()==index)
                return true;
        }
        return false;
    }
}
