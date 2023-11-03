package lotto;

public enum ErrorMessages {
    NOT_DIVISIBLE_BY_THOUSAND("[ERROR]1000원 단위로만 입력 가능합니다."),
    NON_NUMERIC_INPUT("[ERROR]숫자만 입력해주세요.");
    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}