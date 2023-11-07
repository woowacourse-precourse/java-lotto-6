package lotto.constants;

public enum ErrorConstants {
    PLEASE_ENTER_VALUE("값을 입력해 주세요."),
    ONLY_ENTER_NUMBERS("숫자만 입력하실 수 있습니다.");

    private static final String ERROR_TAG = "[ERROR] ";
    private final String ErrorConstants;

    ErrorConstants(String errorConstants) {
        this.ErrorConstants = ERROR_TAG + errorConstants;
    }
    public String getData() {
        return ErrorConstants;
    }

}
