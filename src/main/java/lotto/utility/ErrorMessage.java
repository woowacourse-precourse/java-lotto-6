package lotto.utility;

public enum ErrorMessage {
    NOT_NUMBER_ERROR("[ERROR] 구입 금액은 숫자 이외의 문자를 입력할 수 없습니다."),
    OUT_UNIT_ERROR("[ERROR] 구입 급액은 1000원 단위로만 입력할 수 있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
