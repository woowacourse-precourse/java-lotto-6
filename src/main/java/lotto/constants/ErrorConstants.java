package lotto.constants;

public enum ErrorConstants {
    PLEASE_ENTER_VALUE("값을 입력해 주세요.");

    private static final String ERROR_TAG = "[ERROR] ";
    private final String ErrorConstants;

    ErrorConstants(String errorConstants) {
        this.ErrorConstants = ERROR_TAG + errorConstants;
    }
    public String getData() {
        return ErrorConstants;
    }

}
