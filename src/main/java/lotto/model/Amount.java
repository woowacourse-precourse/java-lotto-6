package lotto.model;

public class Amount {
    private static final int MINIMUM_AMOUNT = 0;
    private static final int LOTTO_PRICE = 1000;
    private final int amount;

    private Amount(int amount) {
        this.amount = amount;
    }

    public static Amount create(String amountStr) {
        int amount = validateNotNumber(amountStr);
        validateNegativeNumber(amount);
        validateAmountInThousandUnit(amount);
        return new Amount(amount);
    }

    public int getAmount() {
        return this.amount;
    }

    private static int validateNotNumber(String amountStr) {
        try {
            return Integer.parseInt(amountStr);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }

    private static void validateNegativeNumber(int amount) {
        if (amount < MINIMUM_AMOUNT) {
            throw new IllegalArgumentException(String.format("[ERROR] 구입 금액은 %d보다 작을 수 없습니다.", MINIMUM_AMOUNT));
        }
    }

    private static void validateAmountInThousandUnit(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(String.format("[ERROR] 로또는 %d원 단위로만 구매할 수 있습니다.", LOTTO_PRICE));
        }
    }
}
