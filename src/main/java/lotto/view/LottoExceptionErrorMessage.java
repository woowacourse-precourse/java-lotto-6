package lotto.view;

public enum LottoExceptionErrorMessage {

    INVALID_NUMBER_COUNT("[ERROR] 로또 숫자 개수가 올바르지 않습니다."),
    INVALID_NUMBER_RANGE("[ERROR] 로또 숫자 범위가 올바르지 않습니다."),
    INVALID_DUPLICATION("[ERROR] 로또 숫자는 중복될 수 없습니다."),
    INVALID_NEGATIVE_PAYMENT("[ERROR] 지불 금액은 음수가 될 수 없습니다.");

    private final String message;

    LottoExceptionErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
