package lotto.view;

public enum ErrorMessage {
    PURCHASE_AMOUNT("1000원 단위의 숫자를 입력하여야 합니다.");

    private static final String ERROR_FORMAT = "[ERROR] %s";
    private String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = String.format(ERROR_FORMAT, errorMessage);
    }

    protected void println() {
        System.err.println(errorMessage);
    }
}
