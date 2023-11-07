package lotto.exceptionMessages;

public enum ExceptionMessages {
    EXCEPTION_BLANK_INPUT("공백은 입력할 수 없습니다."),
    EXCEPTION_NUMERIC_INPUT("숫자만 입력할 수 있습니다."),
    EXCEPTION_NUMBER_RANGE("로또 번호는 1~45 사이만 입력 가능합니다."),
    EXCEPTION_NUMBER_SIZE("6개를 입력해야 합니다."),
    EXCEPTION_NUMBER_DUPLICATION("중복된 번호가 존재합니다."),
    EXCEPTION_MONEY_ZERO("0원은 입력할 수 없습니다."),
    EXCEPTION_MONEY_DIVIDE("1,000원 단위만 입력할 수 있습니다.");

    private static final String EXCEPTION_PREFIX = "[ERROR] ";

    public final String message;

    ExceptionMessages(String message) {
        this.message = EXCEPTION_PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
