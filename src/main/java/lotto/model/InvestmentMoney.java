package lotto.model;

import java.math.BigDecimal;
import java.util.Objects;

public final class InvestmentMoney {
    private static final String MAX_MONEY_EXCEPTION_FORMAT = "사용자가 투입할 수 있는 최대 금액은 %,d원 입니다.";
    private static final int MAX_INVESTMENT = 100_000;
    private static final int PERCENT_MULTIPLIER = 100;

    private final int money;

    private InvestmentMoney(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        validateMinimumLimit(money);
        validateMaximumLimit(money);
        validateDivisible(money);
    }

    private void validateMinimumLimit(int money) {
        LottoPrice.STANDARD_PRICE.validateMinimumPurchasePrice(money);
    }

    private void validateMaximumLimit(int money) {
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
        return lottoPrice.createPurchasableLottoCount(this);
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

    public int getMoney() {
        return money;
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
