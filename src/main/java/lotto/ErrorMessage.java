package lotto;

public enum ErrorMessage {
    MINIMUM_AMOUNT("[ERROR] 최소 구입 금액은 1000원 이상입니다."),
    AMOUNT_UNIT("[ERROR] 구입 금액 단위는 1000원입니다."),
    NON_NUMERIC_AMOUNT("[ERROR] 구입 금액은 숫자로 입력해야합니다."),
    OUT_OF_RANGE("[ERROR] 숫자는 1에서 45 사이여야 합니다."),
    EMPTY_INPUT("[ERROR] 아무것도 입력하지 않았습니다."),
    INVALID_NUMBER_COUNT("[ERROR] 6개의 숫자를 입력해야 합니다."),
    NON_NUMERIC_VALUE("[ERROR] 숫자 외 문자를 입력하였습니다."),
    DUPLICATE_NUMBER("[ERROR] 중복된 숫자를 입력하였습니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
