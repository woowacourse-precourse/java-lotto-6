package lotto.domain;

public class Amount {
    private static final int LOTTO_PRICE = 1000;
    private static final int POSITIVE_VALUE = 0;
    private final int amount;

    private Amount(int amount) {
        verifyPositiveAmount(amount);
        this.amount = amount;
    }

    public static Amount from(int amount) {
        verifyMinAmount(amount);
        verifyDivisibleBy(amount);
        return new Amount(amount);
    }

    private static void verifyDivisibleBy(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구입 금액은 1000원 단위로 입력해주세요.");
        }
    }

    private static void verifyMinAmount(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("구입 금액은 최소 1000원 이상으로 입력해야 합니다.");
        }
    }

    private void verifyPositiveAmount(int amount) {
        if (amount < POSITIVE_VALUE) {
            throw new IllegalArgumentException("구입 금액은 음수가 될 수 없습니다.");
        }
    }
}
