package lotto.util;

public enum ExceptionMessage {

    INVALID_NOT_NATURAL_NUMBER("자연수(1000원 단위)만 입력 가능합니다."),
    INVALID_INPUT_LENGTH("6개의 숫자를 입력해주세요."),
    INVALID_INPUT_RANGE("1 ~ 45 사이 숫자만 입력이 가능합니다."),
    INVALID_INPUT_DUPLICATE("중복된 숫자는 허용하지 않습니다."),
    INVALID_INPUT_HAS_BLAMK("공백이 포함되어 있습니다.")
    ;



    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }
}