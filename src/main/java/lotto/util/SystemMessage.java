package lotto.util;

public enum SystemMessage {

    AMOUNT_INPUT("구입금액을 입력해 주세요."),
    PURCHASE_NIO("개를 구매했습니다."),
    ANSWER_INPUT("당첨 번호를 입력해 주세요."),
    BONUS_INPUT("보너스 번호를 입력해 주세요."),
    RESULT_OUTPUT("당첨 통계"),
    RESULT_START("---");

    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
