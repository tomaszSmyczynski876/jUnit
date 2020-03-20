public class PasswordComplexityPolicy {
    private  final int MIN_LENGHT = 8;
    private  final int MIN_DIGITS = 3;

    public boolean verify(String password){
        int pwdLenght = password.length();
        int digitCount = 0;

        for(int i = 0; i < pwdLenght; i++) {
            if(Character.isDigit(password.charAt(i))) {
                digitCount++;
            }
        }

        if ((pwdLenght < MIN_LENGHT) || (digitCount < MIN_DIGITS)) {
            throw new IllegalArgumentException();
        }

        return true;
    }


}
