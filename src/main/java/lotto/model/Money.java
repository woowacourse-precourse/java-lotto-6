package lotto.model;

public class Money {
    private static final int DEFAULT_UNIT = 1000;
    private static final String MONEY_MUST_MULTIPLE_OF_THOUSAND = "[ERROR] 금액은 1,000원 단위로 나누어 떨어져야 합니다.";
    private final int money;

    public Money(Integer money) {
        validate(money);
        this.money = money;
    }

    public void validate(Integer money) {
        if (money % DEFAULT_UNIT != 0) {
            throw new IllegalArgumentException(MONEY_MUST_MULTIPLE_OF_THOUSAND);
        }
    }
}
