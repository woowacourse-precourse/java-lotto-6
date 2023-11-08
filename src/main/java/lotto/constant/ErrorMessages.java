package lotto.constant;

public enum ErrorMessages {

    NOT_NUMBER("입력값이 정수가 아닙니다."),
    NOT_THOUSAND("입력한 금액이 천원 단위가 아닙니다."),
    NOT_ENOUGH_MONEY("입력한 금액이 로또 한 장의 가격보다 적습니다."),
    NOT_LOTTO_NUMBER("입력한 로또 번호가 유효하지 않습니다. 쉼표로 구분한 숫자만 입력 가능합니다."),
    ;

    private static final String ERROR_FORM = "[ERROR]";

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format("%s %s", ERROR_FORM, message);
    }
}
