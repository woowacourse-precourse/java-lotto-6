package lotto.utils;

public enum LottoException {
    LESS_THAN_MINIMUM_LOTTO_NUMBER("로또 번호는 최소 1 이상의 숫자여야 합니다."),
    MORE_THEN_MAXIMUM_LOTTO_NUMBER("로또 번호는 최대 45 이하의 숫자여야 합니다."),
    DUPLICATED_LOTTO_NUMBER("로또 번호는 중복되지 않는 숫자여야 합니다.");

    private static final String ERROR_SYMBOL = "[ERROR] ";
    private final String message;

    LottoException(String message) {
        this.message = message;
    }

    public void throwException() {
        throw new IllegalArgumentException(message);
    }

    public String getMessage() {
        return message;
    }
}
