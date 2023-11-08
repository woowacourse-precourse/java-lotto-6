package lotto.money;

import java.math.BigDecimal;

public class Price {

    private static final int PERCENTAGE_NUMBER = 100;
    private static final String NOT_INTEGER_ERROR = "금액은 정수로 입력하세요.";

    private final Integer price;

    public Price(String price) {
        this.price = validate(price);
    }

    private Integer validate(String amount) {
        try {
            return Integer.valueOf(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_ERROR);
        }
    }

    public BigDecimal calculateProfit(Integer revenue) {
        double profit = (double) revenue / price * PERCENTAGE_NUMBER;
        return new BigDecimal(String.valueOf(profit));
    }

    public boolean isDivisible(Integer number) {
        return price % number == 0;
    }

    public boolean isGreaterThanOrEqualTo(Integer number) {
        return price >= number;
    }

    public Integer calculateQuotient(Integer number) {
        return price / number;
    }
}
