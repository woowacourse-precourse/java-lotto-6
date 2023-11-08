package lotto;

public class Purchase {
    private static final String NOT_NUMBER_ERROR = "[ERROR] 구입할 금액을 숫자로 입력해 주세요.";
    private static final String NOT_DIVISIBLE_ERROR = "[ERROR] 1,000원 단위의 금액을 입력해 주세요.";
    private static final String ZERO_ERROR = "[ERROR] 최소 1,000원 이상의 금액을 입력해 주세요.";

    private final int amount;

    Purchase(String money) {
        validate(money);
        this.amount = Integer.parseInt(money);
    }

    private void validate(String money) {
        int amount = validateNumber(money);
        validateDivisible(amount);
        validateZero(amount);
    }

    private int validateNumber(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR);
        }
    }

    private void validateDivisible(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_ERROR);
        }
    }

    private void validateZero(int amount) {
        if (amount == 0) {
            throw new IllegalArgumentException(ZERO_ERROR);
        }
    }

    public int getQuantity() {
        return amount / 1000;
    }
}
