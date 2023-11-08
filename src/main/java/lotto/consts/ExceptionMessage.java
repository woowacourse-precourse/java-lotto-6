package lotto.consts;

public enum ExceptionMessage {
    INVALID_RANGE_NUMBER("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_LOTTO_SIZE("6개의 숫자를 입력해주세요."),
    WRONG_SEPERATOR_ERROR("로또 번호는 쉼표(,)로 구분합니다."),
    DUPLICATED_VALUE_ERROR("중복된 숫자가 입력되었습니다."),
    INVALID_TINPUT_PRICE("가격은 1000원 단위로 입력해주십시오."),
    INVALID_INPUT_NUMBER("숫자가 아닌 값이 입력되었습니다."),

    NEGATIVE_INPUT_ERROR("양이 아닌 수가 입력되었습니다.");

    private static final String HEAD_MESSAGE = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = HEAD_MESSAGE + message;
    }

    public String getMessage() {
        return message;
    }
}
