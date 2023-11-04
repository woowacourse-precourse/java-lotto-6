package lotto.domain.lotto;

public class Money {
    private static final int LOTTO_PRICE = 1_000;
    private static final int POSITIVE_VALUE = 0;
    private static final int MAX_MONEY = 10_0000;
    private final int money;

    private Money(int money) {
        verifyPositiveMoney(money);
        this.money = money;
    }

    public static Money fromInitialMoney(int money) {
        verifyMinAmount(money);
        verifyMaxAmount(money);
        verifyDivisibleBy(money);
        return new Money(money);
    }

    public static Money fromRemainingMoney(int money) {
        verifyMaxAmount(money);
        verifyDivisibleBy(money);
        return new Money(money);
    }

    private static void verifyDivisibleBy(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구입 금액은 1000원 단위로 입력해주세요.");
        }
    }

    private static void verifyMinAmount(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("구입 금액은 최소 1000원 이상으로 입력해야 합니다.");
        }
    }

    private static void verifyMaxAmount(int money) {
        if (money > MAX_MONEY) {
            throw new IllegalArgumentException("금액은 100,000원 이하로 입력해야 합니다.");
        }
    }

    private void verifyPositiveMoney(int money) {
        if (money < POSITIVE_VALUE) {
            throw new IllegalArgumentException("구입 금액은 음수가 될 수 없습니다.");
        }
    }

    public Money decremented() {
        return Money.fromRemainingMoney(money - LOTTO_PRICE);
    }

    public boolean isNotEnough() {
        return money < LOTTO_PRICE;
    }

    public boolean isEnough() {
        return money >= LOTTO_PRICE;
    }
}
