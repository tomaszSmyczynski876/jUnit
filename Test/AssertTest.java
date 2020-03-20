import org.junit.Test;


import static junit.framework.TestCase.assertSame;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

public class AssertTest {

    @Test
    public void testAssertEquals() {
        String result = "wartosc";
        assertEquals("wartosc" , result);
    }

    @Test
    public void testAssertSame() {
        Long v1 = Long.valueOf(123456);
        Long v2 = v1;
        assertSame("Inny obiekt", v1, v2);
    }

    @Test
    public void testAssertTue() {
        assertTrue("Nieprawda", 4>3);
    }

    @Test
    public void testAssertNotNull() {
        Long v1 = Long.valueOf(12345);
        assertNotNull("Nieprawda", v1);
    }

    @Test
    public void testAssertArrayEquals() {
        int[] t1 = {1,2,3,4,5};
        int[] t2 = {1,2,3,4,5};
        assertArrayEquals(t1,t2);
    }


}
