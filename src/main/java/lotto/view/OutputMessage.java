package lotto.view;

public enum OutputMessage {

    INPUT_PURCHASE_MESSAGE("구입금액을 입력해 주세요."),
    PURCHASED_LOTTO_COUNT_MESSAGE("개를 구매했습니다."),
    INPUT_LOTTO_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    WINNING_STATICS_MESSAGE("당첨 통계\n---"),
    EARNING_RATE_MESSAGE("총 수익률은 %.1f%%입니다.%n"),
    CORRECT_SAME_NUMBER_MESSAGE("%d개 일치"),
    BONUS_BALL_COUNT_MESSAGE(", 보너스 볼 일치"),
    RATE_MESSAGE_FORMAT(" (%s원) - %d개");

    private final String message;

    private OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}