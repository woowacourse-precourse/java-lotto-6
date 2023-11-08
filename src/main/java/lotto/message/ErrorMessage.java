package lotto.message;

public enum ErrorMessage {
    MONEY_UNIT_ERROR("[ERROR] 구매 금액은 1000원 단위의 금액만 가능합니다."),
    EXIST_OF_VALUE_ERROR("[ERROR] 입력 값이 존재하지 않습니다."),
    NUMERIC_INPUT_ERROR("[ERROR] 숫자만 입력이 가능합니다."),
    NEGATIVE_NUMBER_ERROR("[ERROR] 0보다 큰 숫자만 입력이 가능합니다. "),
    NUMERIC_RANGE_ERROR("[ERROR] 1이상 45 이하의 숫자만 입력이 가능합니다."),
    LOTTO_SIZE_ERROR("[ERROR] 6개의 숫자 구성으로 이루어져야합니다."),
    DUPLICATE_NUMBER_ERROR("[ERROR] 중복된 숫자 사용은 불가능합니다."),
    ALREADY_EXIST_ERROR("[ERROR] 이미 존재하는 번호가 포함되어 있습니다."),
    INVALID_COMMA_USAGE_ERROR("쉼표(,)를 올바르게 사용해야합니다");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
