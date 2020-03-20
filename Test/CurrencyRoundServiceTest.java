import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class CurrencyRoundServiceTest {

    @Parameterized.Parameters(name = "{index}: round({1} = {2})")
    public static Iterable<Object[]> testData() {
        return Arrays.asList(new Object[][] {
                {2, BigDecimal.valueOf(123.456), BigDecimal.valueOf(123.46)},
                {0, BigDecimal.valueOf(123.456), BigDecimal.valueOf(123)},
                {1, BigDecimal.valueOf(123.111), BigDecimal.valueOf(123.1)}
                });
    }

    public int roundPrecision;
    public BigDecimal testedValue;
    public BigDecimal expectedValue;

    public CurrencyRoundServiceTest(int roundPrecision, BigDecimal testedValue, BigDecimal expectedValue) {
        this.roundPrecision = roundPrecision;
        this.testedValue = testedValue;
        this.expectedValue = expectedValue;
    }


    @Test
    public void shouldRoundAmount() {
        CurrencyRoundService currencyRoundService = new CurrencyRoundService(roundPrecision);
        BigDecimal result = currencyRoundService.round(testedValue);
        assertThat(result, is(equalTo(expectedValue)));
    }

    @Test
    public void shouldRoundAmountClassicVersion() {
        CurrencyRoundService currencyRoundService = new CurrencyRoundService(2);
        BigDecimal result = currencyRoundService.round(BigDecimal.valueOf(123.456));
        assertThat(result, is(equalTo(BigDecimal.valueOf(123.46))));
    }
}