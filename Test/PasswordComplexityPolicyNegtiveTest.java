import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PasswordComplexityPolicyNegtiveTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private PasswordComplexityPolicy passwordComplexityPolicy;

    @Before
    public void init() {
        expectedException.expect(IllegalArgumentException.class);
        passwordComplexityPolicy = new PasswordComplexityPolicy();
    }

    @Test
    public void shouldThrowExceptionForTooShort(){
        String password = "q123";
        boolean result = passwordComplexityPolicy.verify(password);
    }

    @Test
    public void shouldThrowExceptionForNoDigits(){
        String password = "aaazxcvb";
        boolean result = passwordComplexityPolicy.verify(password);
    }
}
