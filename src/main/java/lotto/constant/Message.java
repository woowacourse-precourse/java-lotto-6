package lotto.constant;

public enum Message {
    INPUT_BUDGET("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER("당첨번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PURCHASED_LOTTO_COUNT_MESSAGE("개를 구매했습니다."),
    RESULT_MESSAGE("당첨 통계")
    ;

    private final String message;
    Message(String s) {
        this.message = s;
    }
    public String getMessage() {
        return message;
    }
}
