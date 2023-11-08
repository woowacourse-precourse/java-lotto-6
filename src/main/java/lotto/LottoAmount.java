package lotto;

public class LottoAmount {
    public static final int LOTTO_PRICE = 1000;
    private final int amount;

    public LottoAmount(String inputAmount) {
        int amountNum = validateNumber(inputAmount);
        validatePrice(amountNum);
        validateDivisible(amountNum);
        this.amount = amountNum;
    }

    private static int validateNumber(String inputAmount) throws IllegalArgumentException {
        try {
            return Integer.parseInt(inputAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }

    private static void validatePrice(int inputAmount) {
        if (inputAmount < 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0원 이상이어야 합니다.");
        }
    }

    private static void validateDivisible(int inputAmount) {
        if (inputAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위이어야 합니다.");
        }
    }
}
