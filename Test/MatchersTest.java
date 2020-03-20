import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class MatchersTest {

    @Test
    public void testEqualsTo(){
        String result = "wynik";
        assertThat(result, equalTo("wynik"));
        //assertThat(result, is("wynik"));
    }

    @Test
    public void testStrings(){
        String result = "wynik bardzo skomplikowanej metody";
        assertThat(result, containsString("bardzo"));
        assertThat(result, startsWith("wynik"));
        assertThat(result, endsWith("ody"));
    }

    @Test
    public void testStringsAllOf() {
        String result = "wynik bardzo skomplikowanej metody";
        assertThat(result, allOf(containsString("bardzo"), startsWith("wynik"), endsWith("ody")));
    }

    @Test
    public void testStringsAnyOf() {
        String result = "wynik bardzo skomplikowanej metody";
        assertThat(result, anyOf(containsString("bardzo"), startsWith("wynik"), endsWith("ody")));
    }

    @Test
    public void testStringsComposed() {
        String result = "wynik bardzo skomplikowanej metody";
        assertThat(result, allOf(containsString("bardzo"),
                anyOf(containsString("bardzo"), startsWith("wynik"), endsWith("ody"))));
    }
}
