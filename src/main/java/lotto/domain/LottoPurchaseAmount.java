package lotto.domain;

public class LottoPurchaseAmount {
    private final int value;

    LottoPurchaseAmount(int value) {
        validateMinimumAmount(value);

        this.value = value;
    }

    private void validateMinimumAmount(int amount) {
        if (amount == 0) {
            throw new IllegalArgumentException("[ERROR] 최소 1개 이상의 로또를 구매해야 합니다.");
        }
    }

    public static LottoPurchaseAmount from(int price) {
        validateDivisible(price);

        int amount = price / Lotto.PRICE;
        return new LottoPurchaseAmount(amount);
    }

    private static void validateDivisible(int price) {
        if (price % Lotto.PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구매는 1,000원 단위로만 가능합니다.");
        }
    }

    public int value() {
        return value;
    }
}
