package lotto.constant;

public enum ErrorMessage {
    COMMON_ERROR("[ERROR] "),
    EMPTY_INPUT_ERROR("공백을 입력하지 마세요."),
    NOT_NUMBER_ERROR("문자가 아닌 숫자를 입력해주세요."),
    PURCHASE_AMOUNT_UNIT_ERROR("1000원 단위로 입력해주세요."),
    PURCHASE_AMOUNT_ERROR("1000원 이상으로 입력해주세요."),
    SEPARATOR_ERROR("구분자는 ',' 를 사용해주세요"),
    NUMBER_BOUND_ERROR("1 ~ 45 사이의 숫자를 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return COMMON_ERROR.message + message;
    }

}
