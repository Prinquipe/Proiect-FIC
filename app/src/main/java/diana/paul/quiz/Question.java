package diana.paul.quiz;

public class Question {
    private String text;
    private String category;
    private int index;
    private int correctAnswer;

    private static int _count=0;

    public Question() {
        index=_count;
        _count++;
    }

    public boolean isCategory(String cat){

        return category.equals(cat);
    }

    public String getText(){
        return text;
    }


    public int getIndex() {
        return index;
    }

    public void setText(String s){
        text=s;
    }

    public void setCorrectAnswer(int i){
        correctAnswer=i;
    }

    public void setCategory(String c){
        category=c;
    }

    public String getCategory() {
        return category;
    }

    public int getCorrectAnswer() { return correctAnswer; }

    public boolean isCorrectAns(Answer ans){
        if(ans.getIndex()==correctAnswer)
            return true;
        return false;
    }

    public boolean equals(Object obj){
        if(obj instanceof Question) {
            if(index==((Question)obj).getIndex())
                return true;
        }
        return false;
    }
}

