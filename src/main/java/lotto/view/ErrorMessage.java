package lotto.view;

public enum ErrorMessage {
    ERROR_NOT_NUMBER_MESSAGE("[ERROR] 숫자만 입력해주세요."),
    ERROR_NOT_THOUSAND_MESSAGE("[ERROR] 1000단위의 숫자를 입력해주세요.");

    private final String msg;

    private ErrorMessage(String msg) {
        this.msg = msg;
    }
    public String getValue() {
        return msg;
    }
}
