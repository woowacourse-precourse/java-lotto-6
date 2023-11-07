package lotto.enums;

public enum ErrorMessage {
    NUMERIC_ERROR("[ERROR] 숫자가 아닌 입력값입니다."),
    LESS_AMOUNT_ERROR("[ERROR] 1000원 이상을 입력해야합니다."),
    LESS_AMOUNT_UNIT_ERROR("[ERROR] 1000원 단위로 입력해야합니다."),
    HAS_NOT_COMMA_ERROR("[ERROR] 쉼표(,)가 포함되어 있지 않습니다."),
    HAS_SPACE_ERROR("[ERROR] 띄어쓰기가 포함되어 있습니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
