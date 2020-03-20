import org.junit.Test;

import static junit.framework.TestCase.assertTrue;


public class PasswordComplexityPolicyTest {

    @Test
    public void shouldBeCorrectForVeriwyPasswordWithd3Digits() {
        PasswordComplexityPolicy passwordComplexityPolicy = new PasswordComplexityPolicy();
        final String CorrectPassword = "qwert123";

        boolean result = passwordComplexityPolicy.verify(CorrectPassword);

        assertTrue("Wynik dla " + CorrectPassword, result);
    }

    @Test
    public void shouldBeCorrectForVeriwyPasswordWithd3DigitsOnBegining() {
        PasswordComplexityPolicy passwordComplexityPolicy = new PasswordComplexityPolicy();
        final String CorrectPasswordDigitFirst = "123zxcvb";

        boolean result = passwordComplexityPolicy.verify(CorrectPasswordDigitFirst);

        assertTrue("Wynik dla " + CorrectPasswordDigitFirst, result);
    }



}