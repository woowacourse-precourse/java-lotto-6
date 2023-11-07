package lotto.utils;

public enum Message {
    PAYMENT_INPUT_MESSAGE("구입금액을 입력해 주세요."),
    TICKEY_NUMBER_MESSAGE("%d개를 구매했습니다."),
    WINNING_NUMBER_INPUT_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT_MESSAGE("보너스 번호를 입력해 주세요."),
    WINNING_RESULT_MESSAGE("당첨 통계"+'\n'+"---"),
    WINNING_RATE_MASSAGE("총 수익률은 %.1f");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
