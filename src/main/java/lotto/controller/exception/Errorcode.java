package lotto.controller.exception;

public enum Errorcode {

    INVALID_PRICE("구입 금액이 유효하지 않습니다."),
    NOT_NUMBER("입력이 숫자가 아닙니다."),
    NOT_6_UNIQUE_NUMBERS("로또 번호는 중복 없이 6개를 입력해야 합니다."),
    NOT_IN_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATION_EXISTS("입력된 로또 번호에 중복이 있습니다.");

    private final String message;

    Errorcode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
