package lotto.exception;

public enum ExceptionMessage {
    EMPTY("빈 값을 입력할 수 없습니다."),
    NOT_NUMBER("숫자만 입력해야 합니다."),
    // TODO: 매직넘버 상수화하기
    INDIVISIBLE("1,000으로 나누어 떨어지는 금액을 입력해주세요."),
    DUPLICATED("중복된 값을 입력할 수 없습니다."),
    OUT_OF_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    public static final String BASE_MESSAGE = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = BASE_MESSAGE + message;
    }

    public String getMessage() {
        return message;
    }
}
