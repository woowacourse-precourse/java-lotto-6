package lotto.string;

public enum ErrorMessage {
    AMOUNT_CHARACTER_ERROR_MESSAGE("[ERROR] 구입 금액은 숫자가 입력 되어야 합니다."),
    AMOUNT_UNIT_ERROR_MESSAGE("[ERROR] 구입 금액은 거스름 돈이 생기면 안됩니다."),
    WININGNUMBER_CHARACTER_ERROR_MESSAGE("[ERROR] 당첨 번호는 숫자가 입력 되어야 합니다."),
    WININGNUMBER_RANGE_ERROR_MESSAGE("[ERROR] 당첨 번호는 1~45의 숫자가 입력 되어야 합니다."),
    ;

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
