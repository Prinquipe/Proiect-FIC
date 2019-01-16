package diana.paul.quiz.data_write_read;


public interface FileStreamer {

    boolean writeInQuestionFile(String text);

    String readFromQuestionFile();

    boolean writeInAnswerFile(String text);

    String readFromAnswserFile();

    boolean writeInTopFile(String text);

    String readFromTopFile();

}
