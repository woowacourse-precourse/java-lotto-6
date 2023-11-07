package lotto.messages;

public enum ErrorMessages {

    INVALID_INTEGER_MESSAGE("정수 범위의 값이 필요합니다."),
    INVALID_MULTIPLE_OF_1000_MESSAGE("1000의 배수인 숫자가 필요합니다."),
    INVALID_PLUS_OUT_OF_INTEGER("정수 범위를 벗어난 값은 더할 수 없습니다."),
    EMPTY_MESSAGE("하나 이상의 값이 필요합니다."),
    DUPLICATE_NAME_MESSAGE("중복된 값은 입력할 수 없습니다."),
    INVALID_LOTTO_NUMBER_COUNT_MESSAGE("정해진 개수의 숫자를 입력하세요."),
    INVALID_LOTTO_NUMBER_RANGE_MESSAGE("정해진 범위의 숫자를 입력하세요.");

    private String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
