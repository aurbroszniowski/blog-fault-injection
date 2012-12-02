import java.io.IOException;import java.lang.String;

public interface DiskWriterService {
  void write(String filename, String content) throws IOException;
}
