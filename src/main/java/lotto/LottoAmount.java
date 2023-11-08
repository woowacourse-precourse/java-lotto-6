package lotto;

public class LottoAmount {
    public static final int LOTTO_PRICE = 1000;
    private final int amount;

    public LottoAmount(int amount) {
        validatePrice(amount);
        validateDivisible(amount);
        this.amount = amount;
    }

    private static void validatePrice(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 이상이어야 합니다.");
        }
    }

    private static void validateDivisible(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위이어야 합니다.");
        }
    }

    public int calculateAmount() {
        return amount / LOTTO_PRICE;
    }
}
