package diana.paul.quiz.globals;

public class Globals {

    private String category;


    private int score;

    private static Globals _instance=null;

    private Globals(){
        score=0;
    }

    public int getScore(){
        return score;
    }

    public String getCategory(){
        return category;
    }

    public void setScore(int i){
        score=i;
    }

    public void setCategory(String c){
        category=c;
    }

    public static Globals getInstance(){
        if(_instance==null)
            _instance=new Globals();
        return _instance;
    }
}
