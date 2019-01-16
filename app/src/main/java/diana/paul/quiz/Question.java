package diana.paul.quiz;

public class Question {
    private String text;
    private String category;
    private int index;
    private Answer correctAnswer;

    private static int _count=0;

    public Question(String text, Answer a) {
        this.text=text;
        correctAnswer=a;
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

    public void setCategory(String c){
        category=c;
    }

    public String getCategory() {
        return category;
    }

    public Answer getCorrectAnswer() { return correctAnswer; }

    public boolean equals(Object obj){
        if(obj instanceof Question) {
            if(index==((Question)obj).getIndex())
                return true;
        }
        return false;
    }
}

