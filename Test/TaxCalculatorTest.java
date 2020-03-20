import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaxCalculatorTest {
    private TaxCalculator taxCalculator;

    @Before
    public void init(){
        taxCalculator = new TaxCalculator();
    }

    @Test
    public void ShouldBeHighTax(){
        double tax = taxCalculator.calclateTax(3091);
        assertEquals(0d, tax, 0.0000001);
    }

    @Test
    public void ShouldBeTaxFree() {
        double tax = taxCalculator.calclateTax(100000);
        assertEquals(19470.06d, tax, 0.0000001);
    }

}
