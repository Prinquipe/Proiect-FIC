package diana.paul.quiz.data_write_read;

public abstract class AnswerFileStreamer {

    public abstract String readFromAnswerFile();

    public abstract boolean writeInAnswerFile(String text);

    public static AnswerFileStreamer getAnswerFileStreamer(){
        return ConcreteAnswerFileStreamer.getConcreteAnswerFileStreamer();
    }
    }
