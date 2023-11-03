package lotto.Validator;

public enum ValidatorConstant {
    PARSE_INT_ERROR("[ERROR] 정수만 입력할 수 있습니다."),
    Not_DIVISION_BY_1000_ERROR("[ERROR] 1000원 단위로만 구매할 수 있습니다.");

    private final String message;

    ValidatorConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
