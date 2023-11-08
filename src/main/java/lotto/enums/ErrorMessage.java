package lotto.enums;

public enum ErrorMessage {
    EMPTY_AMOUNT("구입 금액이 비어있습니다."),
    EMPTY_NUMBER("빈 로또 번호가 존재합니다."),
    NOT_INTEGER("정수가 아닙니다."),
    NOT_DIVIDED_BY_1000("구입 금액이 1000으로 나누어 떨어지지 않습니다."),
    LESS_THEN_MINIMUM("최소 구입 금액은 1000원 입니다."),
    NOT_NUMBER_INRANGE("로또 번호의 범위는 1부터 45 까지 입니다."),
    NOT_NUMBER_6("로또 번호 갯수가 6개가 아닙니다."),
    NUMBER_DUBPLICATE("중복된 로또 번호가 존재합니다."),
    NUMBER_DUBPLICATE_BONUS_NUMBER("로또 번호와 보너스 번호가 일치합니다."),
    PREFIX("[ERROR] ");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX.message + message;
    }
}
