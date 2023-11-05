package lotto.model;

public class PurchaseAmount {

    public static final int LOTTO_PRICE = 1_000;

    public static final String INVALID_PURCHASE_AMOUNT =
            LOTTO_PRICE + "원 단위의 숫자를 입력하세요. 최소" + LOTTO_PRICE + "원, 최대 10만 원을 구입할 수 있습니다.";

    private static final int MAX_AMOUNT = 1_000_000;
    private static final int NO_REMAINDER = 0;

    private final int amount;

    private PurchaseAmount(final int amount) {
        validate(amount);
        this.amount = amount;
    }

    public static PurchaseAmount from(final int amount) {
        return new PurchaseAmount(amount);
    }

    private void validate(final int amount) {
        if (isNotInRange(amount) || isNotMultipleOfLottoPrice(amount)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNotInRange(final int amount) {
        return amount < LOTTO_PRICE || amount > MAX_AMOUNT;
    }

    private boolean isNotMultipleOfLottoPrice(final int amount) {
        return (amount % LOTTO_PRICE) != NO_REMAINDER;
    }

    public int toInt() {
        return amount;
    }
}
