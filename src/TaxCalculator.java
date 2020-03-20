public class TaxCalculator {

    public double calclateTax(double amount) {

        if(amount <= 3091d) {
            return 0;
        } else  if ( amount <= 85528d) {
            return Math.round(amount * 0.18 * 100) / 100d - 556.02;
        }

        return 14839.02 +  Math.round((amount - 85528d) * 0.32 * 100) / 100d;
    }
}
