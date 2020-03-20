import java.math.BigDecimal;

public class RateConventerService {
    private RateProvider rateProvider;
    private CurrencyRoundService currencyRoundService;

    public RateConventerService(RateProvider rateProvider, CurrencyRoundService currencyRoundService) {
        this.rateProvider = rateProvider;
        this.currencyRoundService = currencyRoundService;
    }

    public BigDecimal convert(String currency, BigDecimal amount){
        BigDecimal rate = rateProvider.getRate(String.valueOf(amount));
        BigDecimal result = amount.multiply(rate);
        return currencyRoundService.round(result);
    }

}
