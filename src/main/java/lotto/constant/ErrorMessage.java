package lotto.constant;

public enum ErrorMessage {

    INDIVISIBLE_PRICE_ERROR("나누어 떨어지지 않는 구입금액 입니다."),
    WRONG_TYPE_PRICE_ERROR("잘못된 형식의 구입금액 입니다."),

    INCORRECT_INPUT_COUNT("잘못된 개수의 입력값이 입력되었습니다."),
    WRONG_TYPE_INPUT_ERROR("정수가 아닌 숫자가 포함되어 있습니다."),

    DUPLICATED_NUMBER_ERROR("중복된 숫자가 존재합니다."),
    NUMBER_RANGE_ERROR("로또 번호는 1부터 45 사이의 숫자여야 합니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }
}
