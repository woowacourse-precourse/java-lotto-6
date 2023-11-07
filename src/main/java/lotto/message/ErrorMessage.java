package lotto.message;

public enum ErrorMessage {
    MONEY_UNIT_ERROR("[ERROR] 구매 금액은 1000원 단위의 금액만 가능합니다."),
    EXIST_OF_VALUE_ERROR("[ERROR] 입력 값이 존재하지 않습니다."),
    NUMERIC_INPUT_ERROR("[ERROR] 숫자만 입력이 가능합니다."),
    NEGATIVE_NUMBER_ERROR("[ERROR] 0보다 큰 숫자만 입력이 가능합니다. ");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
