package lotto.util;

public enum ErrorMessage {

    NUMERIC_ERROR("숫자만 입력 가능 합니다."),
    NEGATIVE_INT_ERROR("자연수만 입력 가능 합니다."),
    MONEY_UNIT_ERROR("1000원 단위만 입력 가능 합니다."),
    LOTTO_SIZE_ERROR("로또는 6자리 숫자로 이루어 집니다."),
    LOTTO_DUPLICATE_ERROR("중복된 숫자는 불가능 합니다."),
    NEGATIVE_NUMBER_ERROR("자연수만 입력 가능합니다."),
    NUMBER_RANGE_ERROR("1이상 45이하의 숫자만 가능합니다."),
    ALREADY_CONTAINS_ERROR("당첨 번호에 이미 포함된 번호 입니다."),
    SPLIT_REGEX_ERROR("쉼표(,)로만 구분 가능합니다.");

    private static final String ERROR_FORMAT = "[ERROR] %s";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format(ERROR_FORMAT, message);
    }

}
