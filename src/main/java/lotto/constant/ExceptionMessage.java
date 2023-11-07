package lotto.constant;

public enum ExceptionMessage {

    ENTER_SIX_NUMBER("숫자를 6개 입력해 주세요."),
    ENTER_CORRECT_RANGE_NUMBER("1 ~ 45 사이의 숫자를 입력해 주세요."),
    ENTER_NOT_DUPLICATION_NUMBER("숫자가 중복되지 않게 입력해 주세요."),
    ENTER_GREATER_THAN_ZERO("0 이상의 값을 입력해 주세요."),
    ENTER_LESS_THAN_MAX_MONEY("이하의 값을 입력해 주세요."),
    ENTER_DIVISIBLE_BY_THOUSAND("1000으로 나누어 떨어지는 값을 입력해 주세요.");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
