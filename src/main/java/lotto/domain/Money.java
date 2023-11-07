package lotto.domain;

public class Money {

    private static final String ERROR_MESSAGE_HEADER = "[ERROR] ";
    private static final String ERROR_NOT_PURCHASABLE = "불가능한 금액입니다.";
    private static final String ERROR_NOT_DIVISIBLE = "천원 단위로 입력해주세요.";
    private static final String ERROR_NEGATIVE_MONEY = "금액은 음수가 될 수 없습니다.";
    private static final long LOTTO_PRICE = 1000;
    private static final int ONE_HUNDRED_PERCENT = 100;
    private static final long ZERO = 0;

    private long money;

    public Money(long money) {
        validate(money);
        this.money = money;
    }

    public long getMoney() {
        return money;
    }

    private void validate(long money) {
        validateNegativePurchaseMoney(money);
        validateMinimumPurchaseMoney(money);
        validateDivisibleByLottoPrice(money);
    }

    public long calculatePurchasableLottosCount() {
        return money / LOTTO_PRICE;
    }

    public double calculateRateOfReturn(Money totalWinningPrize) {
        return (totalWinningPrize.money / (double) this.money) * ONE_HUNDRED_PERCENT;
    }

    private void validateMinimumPurchaseMoney(long money) {
        if (notPurchasable(money)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEADER + ERROR_NOT_PURCHASABLE);
        }
    }

    private void validateDivisibleByLottoPrice(long money) {
        if (notDivisibleByLottoPrice(money)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEADER + ERROR_NOT_DIVISIBLE);
        }
    }

    private void validateNegativePurchaseMoney(long money) {
        if (isNegative(money)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEADER + ERROR_NEGATIVE_MONEY);
        }
    }

    private boolean notPurchasable(long money) {
        return (money < LOTTO_PRICE) && (money > ZERO);
    }

    private boolean notDivisibleByLottoPrice(long money) {
        return (money % LOTTO_PRICE) != ZERO;
    }

    private boolean isNegative(long money) {
        return money < ZERO;
    }
}
