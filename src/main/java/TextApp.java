import java.lang.Exception;import java.lang.String;import java.lang.System;public class TextApp {

  public static void main(String[] arg) {
    try {
      String filename = "someFile.txt";
      String content = "Let's write this in the file";
      WriterService writerService = new WriterServiceImpl();
      writerService.writeOnDisk(filename, content);
    } catch (Exception e) {
      System.out.println("We couldn't write on the disk. " + e.getMessage());
    }
  }

}
