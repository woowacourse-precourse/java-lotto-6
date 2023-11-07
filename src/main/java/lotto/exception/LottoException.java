package lotto.exception;

public enum LottoException {
    NOT_VALID_LOTTO_NUMBERS_SIZE("로또 번호는 6개의 숫자여야 합니다."),
    LESS_THAN_MINIMUM_LOTTO_NUMBER("로또 번호는 최소 1 이상의 숫자여야 합니다."),
    MORE_THAN_MAXIMUM_LOTTO_NUMBER("로또 번호는 최대 45 이하의 숫자여야 합니다."),
    DUPLICATED_LOTTO_NUMBER("로또 번호는 중복되지 않는 숫자여야 합니다."),
    DUPLICATED_BONUS_NUMBER("보너스 번호는 로또 번호와 중복되지 않는 숫자여야 합니다."),

    NOT_VALID_PURCHASE_AMOUNT_UNIT("구입 금액은 1,000원 단위여야 합니다."),
    LESS_THAN_MINIMUM_PURCHASE_AMOUNT("구입 금액은 최소 1,000원 이상이어야 합니다."),
    MORE_THAN_MAXIMUM_PURCHASE_AMOUNT("구입 금액은 최대 20,000원 이하여야 합니다.");


    private static final String ERROR_SYMBOL = "[ERROR] ";
    private final String message;

    LottoException(String message) {
        this.message = ERROR_SYMBOL + message;
    }

    public void throwException() {
        throw new IllegalArgumentException(message);
    }

    public String getMessage() {
        return message;
    }
}
