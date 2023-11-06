package lotto.exception;

public enum LottoException {

    NOT_SIX_NUMBERS("로또 번호는 6개여야 합니다.");

    private final String exceptionMessage;

    LottoException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
        printExceptionMessage();
    }

    public String getExceptionMessage() {
        return this.exceptionMessage;
    }

    private void printExceptionMessage() {
        String ERROR = "[ERROR] ";
        System.out.println(ERROR + this.exceptionMessage);
    }
}
