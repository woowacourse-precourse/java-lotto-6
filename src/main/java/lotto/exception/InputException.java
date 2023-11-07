package lotto.exception;

public enum InputException {

    NOT_INTEGER("입력 숫자가 정수가 아닙니다.");

    private final String exceptionMessage;

    InputException(String exceptionMessage) {
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
