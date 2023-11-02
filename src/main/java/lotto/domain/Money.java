package lotto.domain;

public class Money {
    private static final String NULL_OR_EMPTY_ERROR_MESSAGE = "[ERROR] 공백이나 빈 값으로는 로또 구매가 불가능합니다.";
    private static final String NAN_ERROR_MESSAGE = "[ERROR] 숫자가 아닌 값은 입력이 불가능합니다.";
    private final int amount;

    public Money(String amount) {
        validateNullOrEmpty(amount);
        int parsedAmount = toInt(amount);
        this.amount = parsedAmount;
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
}
