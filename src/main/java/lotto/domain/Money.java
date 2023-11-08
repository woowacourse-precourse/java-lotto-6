package lotto.domain;

public class Money {
    private static final String UNIT_ERROR = "[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.";
    private static final String MONEY_AMOUNT_ERROR = "[ERROR] 구입 금액은 1,000,000원 이하로 입력해야 합니다.";

    private static final int LOTTO_PER_PRICE = 1_000;
    private static final int MAX_PURCHASE_PRICE = 1_000_000;

    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    public int countPurchasedCount() {
        return money / LOTTO_PER_PRICE;
    }

    public double calculateReturnRate(Long winningAmount) {
        return (double) winningAmount / money * 100;
    }

    private void validate(int money) {
        validateUnit(money);
        validateAmountSize(money);
    }

    private void validateUnit(int money) {
        if (money % LOTTO_PER_PRICE != 0) {
            throw new IllegalArgumentException(UNIT_ERROR);
        }
    }

    private void validateAmountSize(int money) {
        if (money > MAX_PURCHASE_PRICE) {
            throw new IllegalArgumentException(MONEY_AMOUNT_ERROR);
        }
    }
}