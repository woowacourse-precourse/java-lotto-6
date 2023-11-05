package lotto.model;

public class Amount {
    private final int amount;

    private Amount(int amount) {
        this.amount = amount;
    }

    public static Amount create(String amountStr) {
        validateEmpty(amountStr);
        int amount = validateNotNumber(amountStr);
        validateNegativeNumber(amount);
        validateAmountInThousandUnit(amount);
        return new Amount(amount);
    }

    public int getAmount() {
        return this.amount;
    }

    private static void validateEmpty(String amountStr) {
        if (amountStr.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 구입 금액을 입력해 주세요.");
        }
    }

    private static int validateNotNumber(String amountStr) {
        try {
            return Integer.parseInt(amountStr);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }

    private static void validateNegativeNumber(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 작을 수 없습니다.");
        }
    }

    private static void validateAmountInThousandUnit(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또는 천원 단위로만 구매할 수 있습니다.");
        }
    }
}
