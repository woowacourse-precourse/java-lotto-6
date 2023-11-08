package lotto.constant;

public enum ErrorMessageConstant {
    ERROR("[ERROR]"),
    DUPLICATE_NUMBER_ERROR_MESSAGE("중복된 숫자를 입력하셨습니다."),
    LOTTO_PRICE_INPUT_ERROR_MESSAGE("입력 금액이 1000으로 나누어 떨어지는 숫자여야합니다."),
    LOTTO_NUMBER_SIZE_ERROR_MESSAGE("6개의 숫자를 입력해주세요"),
    LOTTO_NUMBER_INPUT_ERROR_MESSAGE("1에서 45 사이의 숫자를 입력해주세요.");

    private final String message;

    ErrorMessageConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorMessage() {
        return ERROR.getMessage() + " " + message;
    }
}
