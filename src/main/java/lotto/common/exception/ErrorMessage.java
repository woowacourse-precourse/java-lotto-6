package lotto.common.exception;

public enum ErrorMessage {
    BLANK_INPUT("[ERROR] 공백이 아닌 문자를 입력해주세요."),
    INVALID_NUMERIC_INPUT("[ERROR] 숫자로만 입력해주세요."),
    INVALID_THOUNSAND_UNIT_INPUT("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
