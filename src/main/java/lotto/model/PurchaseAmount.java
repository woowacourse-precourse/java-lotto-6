package lotto.model;

import static lotto.model.Lotto.LOTTO_PRICE;

public class PurchaseAmount {

    private static final int MAX_AMOUNT = 100_000;
    private static final int NO_REMAINDER = 0;

    public static final String INVALID_PURCHASE_AMOUNT =
            String.format("%,d", LOTTO_PRICE) + "원 단위의 숫자를 입력하세요. "
                    + "최소 " + String.format("%,d", LOTTO_PRICE) + "원, "
                    + "최대 " + String.format("%,d", MAX_AMOUNT) + "원"
                    + "을 구입할 수 있습니다.\n";

    private final int amount;

    private PurchaseAmount(final int amount) {
        validate(amount);
        this.amount = amount;
    }

    public static PurchaseAmount from(final int amount) {
        return new PurchaseAmount(amount);
    }

    private void validate(final int amount) {
        if (isOutOfRange(amount) || isNotMultipleOfLottoPrice(amount)) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT);
        }
    }

    private boolean isOutOfRange(final int amount) {
        return amount < LOTTO_PRICE || amount > MAX_AMOUNT;
    }

    private boolean isNotMultipleOfLottoPrice(final int amount) {
        return (amount % LOTTO_PRICE) != NO_REMAINDER;
    }

    public int toInt() {
        return amount;
    }
}
