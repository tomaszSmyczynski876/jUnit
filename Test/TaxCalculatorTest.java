import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TaxCalculatorTest {
    private TaxCalculator taxCalculator;

    @Before
    public void init(){
        taxCalculator = new TaxCalculator();
    }

    @Test
    @Category(Easy.class)
    public void ShouldBeHighTax(){
        double tax = taxCalculator.calclateTax(3091);
        assertEquals(0d, tax, 0.0000001);
    }

    @Test
    @Category(Complicated.class)
    public void ShouldBeTaxFree() {
        double tax = taxCalculator.calclateTax(100000);
        assertEquals(19470.06d, tax, 0.0000001);
    }

}
