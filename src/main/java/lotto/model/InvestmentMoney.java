package lotto.model;

import java.math.BigDecimal;
import java.util.Objects;

public final class InvestmentMoney {
    private static final String NEGATIVE_MONEY_EXCEPTION = "사용자가 투입한 금액에서 음수는 입력할 수 없습니다.";
    private static final String ZERO_MONEY_EXCEPTION_FORMAT = "사용자가 투입한 금액에서 %d원은 입력할 수 없습니다.";
    private static final String MAX_MONEY_EXCEPTION_FORMAT = "사용자가 투입한 금액에서 %,d원 이하로 입력해주세요.";
    private static final int ZERO = 0;
    private static final int MAX_INVESTMENT = 100_000;
    private static final int PERCENT_MULTIPLIER = 100;

    private final int money;

    private InvestmentMoney(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        validatePositive(money);
        validateZero(money);
        validateBelowMaximumLimit(money);
        validateDivisible(money);
    }

    private void validatePositive(int money) {
        if (money < ZERO) {
            throw new IllegalArgumentException(NEGATIVE_MONEY_EXCEPTION);
        }
    }

    private void validateZero(int money) {
        if (money == ZERO) {
            String exceptionMessage = String.format(ZERO_MONEY_EXCEPTION_FORMAT, ZERO);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    private void validateBelowMaximumLimit(int money) {
        if (money > MAX_INVESTMENT) {
            String exceptionMessage = String.format(MAX_MONEY_EXCEPTION_FORMAT, MAX_INVESTMENT);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    private void validateDivisible(int money) {
        LottoPrice.STANDARD_PRICE.validateDivisible(money);
    }

    public static InvestmentMoney from(int money) {
        return new InvestmentMoney(money);
    }

    public PurchasableLottoCount calculatePurchasableLottoCount(LottoPrice lottoPrice) {
        return lottoPrice.calculateLottoCount(money);
    }

    public TotalProfitRate calculateTotalProfitRate(TotalPrizeAmount totalPrizeAmount) {
        BigDecimal prizeToInvestmentRatio = totalPrizeAmount.calculatePrizeToInvestmentRatio(money);
        BigDecimal percentMultiplier = BigDecimal.valueOf(PERCENT_MULTIPLIER);
        BigDecimal totalProfitRate = toPercentage(prizeToInvestmentRatio, percentMultiplier);

        return TotalProfitRate.from(totalProfitRate.doubleValue());
    }

    private BigDecimal toPercentage(BigDecimal prizeToInvestmentRatio, BigDecimal percentMultiplier) {
        return prizeToInvestmentRatio.multiply(percentMultiplier);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InvestmentMoney investmentMoney = (InvestmentMoney) o;
        return money == investmentMoney.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
