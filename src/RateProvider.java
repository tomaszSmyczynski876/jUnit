import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Properties;

public class RateProvider {
    Properties rates;

    public void  loadFromFIle(String fileLocatiom) throws IOException {
        System.out.println("Wczytuje z pliku");
        rates = new Properties();
        InputStream inputStream = new FileInputStream(fileLocatiom);
        rates.load(inputStream);
        inputStream.close();
    }

    public void loadFromStream(InputStream stream) throws IOException {
        System.out.println("Wczytuje ze strumienia");
        rates = new Properties();
        rates.load(stream);
    }

    public BigDecimal getRate(String currency) {
        String rateStr = rates.getProperty(currency);
        return new BigDecimal(rateStr);
    }

}
