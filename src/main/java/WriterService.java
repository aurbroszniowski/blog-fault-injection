import java.io.IOException;import java.lang.Exception;import java.lang.String;

public interface WriterService {

  void writeOnDisk(String filename, String content) throws Exception;

}
