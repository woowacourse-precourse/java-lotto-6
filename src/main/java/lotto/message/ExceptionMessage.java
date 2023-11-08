package lotto.message;

public enum ExceptionMessage {
    INPUT_NOT_NUMBER("숫자만 입력 가능합니다"),
    NOT_NATURAL_NUMBER("자연수만 입력 가능합니다"),
    INDIVISIBLE_AMOUNT("구입금액은 1000원 단위여야 합니다"),
    NOT_DIVIDED_BY_COMMA("번호는 쉼표로 구분되어야 합니다"),
    WRONG_NUMBER_LENGTH("로또 번호는 6개입니다"),
    HAS_DUPLICATED_NUMBER("중복된 숫자가 있습니다"),
    NUMBER_NOT_IN_RANGE("로또 번호는 1에서 45까지 중의 숫자입니다");

    private static final String EXCEPTION_MESSAGE_HEADER = "[ERROR] ";
    private final String message;

    private ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return EXCEPTION_MESSAGE_HEADER + this.message;
    }
}
