import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeTrue;

public class CitCalculatorTest {

    @Rule
    public Timeout timeout = Timeout.millis(90);

    private CitCalculator citCalculator;

    @Before
    public void prepareForAllTest() {
        System.out.println("prepareForAllTests");
    }

    @Before
    public void init(){
        citCalculator = new CitCalculator();
        System.out.println("prepare");
    }

    @After
    public void cleanUp(){
        System.out.println("clean");
    }

    @Test(timeout = 50)
    @Category(Trivial.class)
    public void shouldCalculateCit() {
        double tax = citCalculator.calclateTax(1000000d);
        assertEquals(190000d, tax, 0.0000001);
    }

    @Test
    @Category({Trivial.class, Easy.class})
    public void shouldBeZer0() {
        double tax = citCalculator.calclateTax(0);
        assertEquals(0d, tax, 0.0000001);
    }


    @Test
    @Category({Trivial.class, Easy.class})
    public void shoulIgnore() {
        assumeTrue(!System.getProperty("os.name").startsWith("Windows"));
        double tax = citCalculator.calclateTax(0);
        assertEquals(0d, tax, 0.0000001);
    }
}