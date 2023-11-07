package lotto.constants;

public enum LottoErrorMessage {
    LENGTH_INVALID("발행한 로또 번호는 6자리 숫자여야 합니다."),
    RANGE_INVALID("발행한 로또 번호는 1~45의 숫자여야 합니다."),
    DUPLICATE_INVALID("발행한 로또 번호는 중복이 있으면 안됩니다."),
    ;

    private static final String START_ERROR_MESSAGE = "[ERROR] ";
    private final String message;

    LottoErrorMessage(String message) {
        this.message = message;
    }

    public String entireMessage() {
        return (START_ERROR_MESSAGE + getMessage());
    }

    public String getMessage() {
        return this.message;
    }

}
