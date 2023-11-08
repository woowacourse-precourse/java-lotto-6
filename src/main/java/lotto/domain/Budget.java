package lotto.domain;

public class Budget {
    private static final int MINIMUN_BUDGET_UNIT = 1000;
    private final int money;
    private final int lottoCount;


    public Budget(int money) {
        validate(money);
        this.money = money;
        this.lottoCount = this.money / MINIMUN_BUDGET_UNIT;
    }

    public int getMoney() {
        return this.money;
    }

    public int getLottoCount() {
        return this.lottoCount;
    }

    private void validate(int money) {
        if (!isGreaterThanZero(money)) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 자연수여야 합니다.");
        }
        if (!isMultipleOfUnitPrice(money)) {
            throw new IllegalArgumentException(String.format("[ERROR] 구매 금액은 %d의 배수여야 합니다.", MINIMUN_BUDGET_UNIT));
        }
    }

    private boolean isGreaterThanZero(int money) {
        return money > 0;
    }

    private boolean isMultipleOfUnitPrice(int money) {
        return money % MINIMUN_BUDGET_UNIT == 0;
    }
}
