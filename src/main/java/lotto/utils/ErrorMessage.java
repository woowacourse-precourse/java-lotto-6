package lotto.utils;

public enum ErrorMessage {
    INPUT_MONEY_BELOW_MIN_AMOUNT_ERROR("최소 1000원을 입력해야합니다."),
    INPUT_MONEY_ABOVE_MAX_AMOUNT_ERROR("최대 100,000,000원을 입력해야합니다."),
    INPUT_MONEY_NOT_DIVISIBLE_ERROR("1000원 단위의 값을 입력해야합니다."),
    INPUT_MONEY_NOT_INTEGER_ERROR("정수만 입력 가능합니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
