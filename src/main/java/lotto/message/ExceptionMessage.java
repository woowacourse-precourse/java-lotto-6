package lotto.message;

public enum ExceptionMessage {
    IS_NOT_DIGIT("로또 구입 금액은 숫자만 입력 가능합니다."),
    IS_NOT_DIVISIBLE_BY_1000("로또 구입 금액은 1000원 단위만 입력 가능합니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return PREFIX + message;
    }
}
