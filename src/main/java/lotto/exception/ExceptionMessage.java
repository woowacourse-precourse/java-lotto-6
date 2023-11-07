package lotto.exception;

public enum ExceptionMessage {
    OUT_OF_LOTTO_NUMBER_LENGTH("로또 번호의 숫자 범위는 1~45까지이다."),
    BLANK_LOTTO_NUMBER("로또 번호의 숫자는 공백이 될 수 없다."),
    DUPLICATE_LOTTO_NUMBER("로또 번호의 숫자가 중복됩니다."),
    INVAILD_LOTTO_SIZE("로또 번호는 6개 숫자로 이루어졌다"),
    EMPTY_LOTTO("로또 번호들이 존재하지 않습니다.");

    private final static String EXCEPTION_HEADER = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return EXCEPTION_HEADER + message;
    }
}
