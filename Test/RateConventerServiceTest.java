import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class RateConventerServiceTest {

    @Test
    public void convert() {
        RateProvider rateProvider = mock(RateProvider.class);
        when(rateProvider.getRate("EUR")).thenReturn(BigDecimal.valueOf(4));
        RateConventerService rateConventerService = new RateConventerService(rateProvider, new CurrencyRoundService(2));
        BigDecimal result = rateConventerService.convert("EUR", BigDecimal.valueOf(10));
        assertEquals(new BigDecimal("40.00"), result);
    }
}