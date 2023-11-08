package lotto.enums;

public enum MessageType {
    INPUT_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    INPUT_WINNING_MSG("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_MSG("보너스 번호를 입력해 주세요."),
    END_MSG("당첨 통계\n---"),
    ERROR_OUT_OF_BOUNDS("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ERROR_NON_NUMBER("[ERROR] 숫자만 입력해 주세요."),
    ERROR_INCORRECT_NUMBER_OF_INPUTS("[ERROR] 올바른 갯수의 숫자를 입력해 주세요."),
    ERROR_DUPLICATE_WINNING_INPUTS("[ERROR] 중복되지 않는 숫자를 입력해 주세요."),
    ERROR_NOT_OF_THOUSAND("[ERROR] 1000단위의 숫자를 입력해 주세요.");

    private String msg;

    MessageType(String msg){
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }

}
