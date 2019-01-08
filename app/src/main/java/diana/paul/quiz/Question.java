package diana.paul.quiz;

public class Question {
    private String text;
    private String category;
    private int index;
    private int answer_index;

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

    public void setAnswer_index(int answer_index) {
        this.answer_index = answer_index;
    }

    public int getAnswer_index() {
        return answer_index;
    }

    public int getIndex() {
        return index;
    }

    public void setText(String t) {
        text=t;
    }

    public void setCategory(String c){
        category=c;
    }

    public String getCategory() {
        return category;
    }

    public boolean equals(Object obj){
        if(obj instanceof Question) {
            if(index==((Question)obj).getIndex())
                return true;
        }
        return false;
    }
}

