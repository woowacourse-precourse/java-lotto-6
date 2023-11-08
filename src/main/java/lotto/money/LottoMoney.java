package lotto.money;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LottoMoney {

    private static final String WRONG_MONEY_ERROR = "로또는 1000원씩 구매해야 합니다.";
    private static final String INVALID_RANGE_AMOUNT_ERROR = "1000원 이상 입력하세요";
    private static final int LOTTO_PRICE = 1000;
    private static final int ROUNDING_DIGITS = 1;

    private final Price money;

    public LottoMoney(String money) {
        Price price = new Price(money);
        validate(price);
        this.money = price;
    }

    private void validate(Price money) {
        checkMinimumPrice(money);
        checkCorrectUnit(money);
    }

    private void checkMinimumPrice(Price price) {
        if (!isAmountBelowMinimum(price)) {
            throw new IllegalArgumentException(INVALID_RANGE_AMOUNT_ERROR);
        }
    }

    private boolean isAmountBelowMinimum(Price price) {
        return price.isGreaterThanOrEqualTo(LOTTO_PRICE);
    }

    private void checkCorrectUnit(Price price) {
        if (!isDivisibleByLottoPrice(price)) {
            throw new IllegalArgumentException(WRONG_MONEY_ERROR);
        }
    }

    private boolean isDivisibleByLottoPrice(Price money) {
        return money.isDivisible(LOTTO_PRICE);
    }

    public Integer getLottoCount() {
        return money.calculateQuotient(LOTTO_PRICE);
    }

    public Double calculateProfit(Integer totalIncome) {
        BigDecimal profit = money.calculateProfit(totalIncome);
        return profit.setScale(ROUNDING_DIGITS, RoundingMode.HALF_UP).doubleValue();
    }
}
