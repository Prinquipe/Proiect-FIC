package diana.paul.quiz.data_write_read;


public abstract class QuestionFileStreamer {

   public abstract boolean  writeInQuestionFile(String text);

   public abstract String readFromQuestionFile();


}
