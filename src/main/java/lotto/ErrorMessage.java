package lotto;

public enum ErrorMessage {
    WRONG_RANGE_NUMBER("범위를 넘어선 숫자가 존재합니다."),
    DUPLICATE_NUMBER("중복된 숫자가 존재합니다."),
    INCORRECT_AMOUNT("잘못된 구입 금액을 입력하였습니다.");

    private final String message;
    private final String PRE_FACE = "[ERROR]";

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PRE_FACE + message;
    }
}
