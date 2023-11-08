package lotto.constant.messages;


public enum Error {

    NOT_DIGIT("숫자만 입력해주세요."),
    MONEY_TOO_LARGE("금액이 너무 큽니다."),
    NOT_DIVIDABLE("1000원 단위로 입력해주세요."),
    MONEY_TOO_SMALL("금액이 너무 적습니다."),
    INPUT_FORMAT_NULL_OR_EMPTY("입력을 해주세요"),
    LOTTO_NUMBER_OUT_OF_RANGE("유효한 번호가 아닙니다."),
    LOTTO_NOT_SIX_NUMBER("여섯 개의 수를 입력해 주세요"),
    LOTTO_DUPLICATED_NUMBER("중복된 수는 입력할 수 없습니다.");

    private final String message;
    private final String PREFIX = "[ERROR] ";

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + this.message;
    }
}