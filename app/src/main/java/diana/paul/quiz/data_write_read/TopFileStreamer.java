package diana.paul.quiz.data_write_read;

public abstract class TopFileStreamer {

   public abstract boolean writeInTopFile(String text);

   public abstract String readFromTopFile();

   public static TopFileStreamer getTopFileStreamer(){
       return ConcreteTopFileStreamer.getConcreteTopFileStreamer();
   }
}
