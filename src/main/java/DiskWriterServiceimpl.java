import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;import java.lang.String;

public class DiskWriterServiceimpl implements DiskWriterService {
  public void write(final String filename, final String content) throws IOException {
    FileWriter file = new FileWriter(filename);
    BufferedWriter out = new BufferedWriter(file);
    out.write(content);
    out.close();
  }
}
