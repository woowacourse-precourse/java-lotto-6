package lotto.Validator;

public enum ValidatorConstant {
    PARSE_INT_ERROR("[ERROR] 정수만 입력할 수 있습니다. 다시 입력해주세요.");

    private final String message;

    ValidatorConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
