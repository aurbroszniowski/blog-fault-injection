import java.io.IOException;import java.lang.String;

public class FaultyDiskWriterServiceImpl implements DiskWriterService {

  private IOException exception;

  public void write(final String filename, final String content) throws IOException {
    throw exception;
  }

  public void setException(final IOException exception) {
    this.exception = exception;
  }
}
