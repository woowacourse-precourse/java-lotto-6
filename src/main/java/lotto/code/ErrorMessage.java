package lotto.code;

/**
 * ErrorMessage
 * <pre>
 * Describe here
 * </pre>
 *
 * @version 1.0,
 */
public enum ErrorMessage {
    EMPTY_DATA("[ERROR] 빈값 입력 불가입니다."),
    ONLY_NUMBERS("[ERROR] 숫자만 입력 가능합니다."),
    INVALID_AMOUNT_UNIT_INPUT("[ERROR] 로또 구입 단위가 잘 못 되었습니다. 로또 1장 가격 : 1,000원"),
    ;

    private ErrorMessage(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }
}
