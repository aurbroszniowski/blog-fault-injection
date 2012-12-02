
import java.io.IOException;import java.lang.Exception;import java.lang.String;

public class WriterServiceImpl implements WriterService {

  DiskWriterService diskWriterService = new DiskWriterServiceimpl();

  public void writeOnDisk(final String filename, final String content) throws Exception {
    try {
      diskWriterService.write(filename, content);
    } catch (IOException e) {
      throw new Exception("file writing error", e);
    }
  }

  public void setDiskWriterService(final DiskWriterService diskWriterService) {
    this.diskWriterService = diskWriterService;
  }
}
