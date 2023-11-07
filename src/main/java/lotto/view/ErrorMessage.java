package lotto.view;

public enum ErrorMessage {
    ERROR_NOT_NUMBER_MESSAGE("[ERROR] 숫자만 입력해 주세요."),
    ERROR_NOT_THOUSAND_MESSAGE("[ERROR] 1000단위의 숫자를 입력해 주세요."),
    ERROR_NOT_SIX_MESSAGE("[ERROR] 숫자를 6개 입력해주세요."),
    ERROR_NOT_1_TO_45_MESSAGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ERROR_NOT_OVERLAP_MESSAGE("[ERROR] 중복 되지 않은 번호를 입력해 주세요.")
    ;

    private final String msg;

    private ErrorMessage(String msg) {
        this.msg = msg;
    }
    public String getValue() {
        return msg;
    }
}
