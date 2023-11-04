package lotto.model;

import java.math.BigDecimal;
import java.util.Objects;

public final class UserMoney {
    private static final String NEGATIVE_MONEY_EXCEPTION = "사용자가 투입한 금액에서 음수는 입력할 수 없습니다.";
    private static final String ZERO_MONEY_EXCEPTION = "사용자가 투입한 금액에서 0원은 입력할 수 없습니다.";
    private static final String ONE_HUNDRED_MILLION_MONEY_EXCEPTION = "사용자가 투입한 금액에서 1억원 이하로 입력해주세요.";
    private static final int ZERO_MONEY = 0;
    private static final int ONE_HUNDRED_MILLION_MONEY = 100_000_000;
    private static final int PERCENT_MULTIPLIER = 100;

    private final int money;

    private UserMoney(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        validatePositive(money);
        validateNotZero(money);
        validateBelowMaximumLimit(money);
        validateDivisibilityByLottoPrice(money);
    }

    private void validatePositive(int money) {
        if (money < ZERO_MONEY) {
            throw new IllegalArgumentException(NEGATIVE_MONEY_EXCEPTION);
        }
    }

    private void validateNotZero(int money) {
        if (money == ZERO_MONEY) {
            throw new IllegalArgumentException(ZERO_MONEY_EXCEPTION);
        }
    }

    private void validateBelowMaximumLimit(int money) {
        if (money > ONE_HUNDRED_MILLION_MONEY) {
            throw new IllegalArgumentException(ONE_HUNDRED_MILLION_MONEY_EXCEPTION);
        }
    }

    private void validateDivisibilityByLottoPrice(int money) {
        LottoPrice.STANDARD_PRICE.validateDivisibility(money);
    }

    public static UserMoney from(int money) {
        return new UserMoney(money);
    }

    public double calculateProfitPercentage(TotalWinningMoney winningMoney) {
        BigDecimal divided = winningMoney.divide(money);
        BigDecimal value = BigDecimal.valueOf(PERCENT_MULTIPLIER);
        return divided.multiply(value)
                .doubleValue();
    }

    public int calculateLottoPurchaseCount(int lottoPrice) {
        return money / lottoPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserMoney userMoney = (UserMoney) o;
        return money == userMoney.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
