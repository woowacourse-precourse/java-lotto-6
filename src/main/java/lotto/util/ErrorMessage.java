package lotto.util;

public enum ErrorMessage {

    NUMERIC_ERROR("숫자만 입력 가능 합니다."),
    NEGATIVE_INT_ERROR("자연수만 입력 가능 합니다."),
    MONEY_UNIT_ERROR("1000원 단위만 입력 가능 합니다."),
    LOTTO_SIZE_ERROR("로또는 6자리 숫자로 이루어 집니다."),
    LOTTO_DUPLICATE_ERROR("중복된 숫자는 불가능 합니다.");

    private static final String ERROR_FORMAT = "[ERROR] %s";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format(ERROR_FORMAT, message);
    }

}
