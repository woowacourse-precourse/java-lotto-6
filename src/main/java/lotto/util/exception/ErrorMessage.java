package lotto.util.exception;

public enum ErrorMessage {
    INVALID_STRING("숫자만 입력해주세요."),
    INVALID_DIVISIBLE_BY_THOUSAND("1000으로 나누어 떨어져야 합니다."),
    INVALID_ZERO_NUMBER("0이상의 숫자로 입력해야 합니다."),
    INVALID_RANGE("%s 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_LOTTO_COUNT("로또 번호는 6개를 입력해야 합니다."),
    INVALID_DUPLICATE_NUMBER("중복된 번호가 있습니다."),
    INVALID_BLANK("공백은 허용되지 않습니다.");

    private final String errorMessage;

    ErrorMessage(String message) {
        this.errorMessage = "[ERROR] " + message;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

}
