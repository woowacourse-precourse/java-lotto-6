package lotto.domain;

public class Money {
    private static final String NULL_OR_EMPTY_ERROR_MESSAGE = "[ERROR] 공백이나 빈 값으로는 로또 구매가 불가능합니다.";
    
    private final int amount;

    public Money(String amount) {
        validateNullOrEmpty(amount);
        this.amount = Integer.parseInt(amount);
    }

    private void validateNullOrEmpty(String amount) {
        if (amount == null || amount.isBlank()) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_ERROR_MESSAGE);
        }
    }
}
