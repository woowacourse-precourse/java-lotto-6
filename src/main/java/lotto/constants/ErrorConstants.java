package lotto.constants;

public enum ErrorConstants {
    // 공통
    ERROR_PREFIX("[ERROR] "),

    // 입력 값 에러
    ERROR_NULL_INPUT("NULL 값이 입력 되었습니다."),
    ERROR_BLANK_INPUT("공백,빈 값이 입력 되었습니다."),
    ERROR_NON_NUMBER_TYPE_INPUT("숫자 타입의 값이 입력되지 않았습니다."),

    // 로또 번호 에러
    ERROR_LOTTO_NUMBER_SIZE("로또 번호가 6자리가 아닙니다."),
    ERROR_LOTTO_NUMBER_DUPLICATE("중복된 로또 번호가 존재합니다."),
    ERROR_LOTTO_NUMBER_RANGE_OVER("로또 번호의 범위를 벗어났습니다. ( 1 ~ 45 )"),

    // 구매 금액 에러
    ERROR_LESS_THAN_MIN_AMOUNT("구매 금액이 최소 구매 금액(1,000원)보다 미만입니다."),
    ERROR_GREATER_THAN_MAX_AMOUNT("구매 금액이 최대 구매 금액(100,000원)보다 초과 되었습니다."),
    ERROR_DIVIDE_BY_AMOUNT("구매 금액이 1,000원으로 나누어 떨어지지 않습니다."),
    ERROR_QUANTITY_NON_EQUALS("구매 가능 수량이 구매 수량과 일치하지 않습니다."),

    // 당첨 로또 번호 에러
    ERROR_LOTTO_NUMBER_FORMAT("입력 한 형식이 로또 번호 형식이 아닙니다.\n 입력 예) 1,2,3,4,5,6");


    private final String message;

    ErrorConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
