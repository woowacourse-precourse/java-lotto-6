package lotto.message;

public enum ErrorMessage {
    MONEY_UNIT_ERROR("구매 금액은 1000원 단위의 금액만 가능합니다."),
    EXIST_OF_VALUE_ERROR("입력 값이 존재하지 않습니다."),
    NUMERIC_INPUT_ERROR("숫자만 입력이 가능합니다."),
    NEGATIVE_NUMBER_ERROR("0보다 큰 숫자만 입력이 가능합니다. "),
    NUMERIC_RANGE_ERROR("1이상 45 이하의 숫자만 입력이 가능합니다."),
    LOTTO_SIZE_ERROR("6개의 숫자 구성으로 이루어져야합니다."),
    DUPLICATE_NUMBER_ERROR("중복된 숫자 사용은 불가능합니다."),
    ALREADY_EXIST_ERROR("당첨 번호에 이미 존재하는 번호 입니다."),
    INVALID_COMMA_USAGE_ERROR("쉼표(,)를 올바르게 사용해야합니다");

    private final static String ERROR_MESSAGE_HEADER = "[ERROR] %s";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format(ERROR_MESSAGE_HEADER, message);
    }

}
