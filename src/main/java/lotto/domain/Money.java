package lotto.domain;

public class Money {
    private static final String NULL_OR_EMPTY_ERROR_MESSAGE = "[ERROR] 공백이나 빈 값으로는 로또 구매가 불가능합니다.";
    private static final String NAN_ERROR_MESSAGE = "[ERROR] 숫자가 아닌 값은 입력이 불가능합니다.";
    private static final String RANGE_ERROR_MESSAGE = "[ERROR] 1000 이상의 숫자만 입력 가능합니다.";
    private static final String DIVIDE_ERROR_MESSAGE = "[ERROR] 1000원 단위로만 구매가 가능합니다.";

    private final int amount;

    public Money(String amount) {
        validateNullOrEmpty(amount);
        int parsedAmount = toInt(amount);
        validateRange(parsedAmount);
        validateDivisibleBy1000(parsedAmount);

        this.amount = parsedAmount;
    }

    public int getAmount() {
        return amount;
    }

    private void validateNullOrEmpty(String amount) {
        if (amount == null || amount.isBlank()) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_ERROR_MESSAGE);
        }
    }

    private int toInt(String amount) {
        int result;
        try {
            result = Integer.parseInt(amount);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NAN_ERROR_MESSAGE);
        }

        return result;
    }

    private void validateRange(int amount) {
        if (amount <= 1000) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }

    private void validateDivisibleBy1000(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(DIVIDE_ERROR_MESSAGE);
        }
    }
}
