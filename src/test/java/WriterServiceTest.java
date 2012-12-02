import org.junit.Assert;
import org.junit.Test;

import java.io.SyncFailedException;import java.lang.Exception;

public class WriterServiceTest {

  @Test
  public void testSuccessfulWriting() {
    WriterService writerService = new WriterServiceImpl();
    try {
      writerService.writeOnDisk("test.txt", "testContent");
    } catch (Exception e) {
      Assert.fail("We should be able to write to the disk");
    }
  }

  @Test
  public void testFailingWriting() {
    WriterService writerService = new WriterServiceImpl();
    try {
      writerService.writeOnDisk("impossiblefilename^&:/.txt", null);
      Assert.fail("We should not be able to write to the disk");
    } catch (Exception e) {
      Assert.assertEquals("file writing error", e.getMessage());
    }
  }

  @Test
  public void testDiskfull() {
    WriterServiceImpl writerService = new WriterServiceImpl();
    FaultyDiskWriterServiceImpl faultyDiskWriterService = new FaultyDiskWriterServiceImpl();
    faultyDiskWriterService.setException(new SyncFailedException("disk full"));
    writerService.setDiskWriterService(faultyDiskWriterService);
    try {
      writerService.writeOnDisk("diskfullname.txt", null);
      Assert.fail("We should not be able to write to the disk");
    } catch (Exception e) {
      Assert.assertEquals("file writing error", e.getMessage());
    }
  }
}
