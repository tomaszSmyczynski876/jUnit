import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExternalResource;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.math.BigDecimal;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class RateProviderTest {

    private InputStream stream;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Rule
    public ExternalResource resource = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            System.out.println("Tworze zasob");
            stream = new ByteArrayInputStream("USD=3.95".getBytes());
        }

        @Override
        protected void after() {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };


    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test
    public void shouldReadRate() throws IOException {
        File file = temporaryFolder.newFile();
        Properties properties = new Properties();
        properties.put("USD", "3.95");
        OutputStream outputStream = new FileOutputStream(file);
        properties.store(outputStream, null);
        outputStream.close();
        RateProvider provider = new RateProvider();

        provider.loadFromFIle(file.getAbsolutePath());
        BigDecimal result = provider.getRate("USD");

        assertThat(result, equalTo(new BigDecimal("3.95")));

    }

    @Ignore
    @Test
    public void shouldReadRateStream() throws IOException {

        RateProvider provider = new RateProvider();

        provider.loadFromFIle(stream.toString());
        BigDecimal result = provider.getRate("USD");

        assertThat(result, equalTo(new BigDecimal("3.95")));

    }

}