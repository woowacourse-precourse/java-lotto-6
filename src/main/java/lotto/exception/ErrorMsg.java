package lotto.exception;

public enum ErrorMsg {
    LOTTO_NUMBERS_SIZE_MAX("[ERROR] 당첨 번호는 6개 이하로 입력해 주세요."),
    LOTTO_DUPLICATES_NUMBERS("[ERROR] 중복된 숫자가 포함 되어 있습니다."),
    LOTTO_NUMBER_OVER_MAX("[ERROR] 1~45 이하 숫자를 입력해 주세요.");

    private String msg;

    ErrorMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
