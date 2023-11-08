package lotto.view.message;

public enum OutputMessage {
    ASK_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    ASK_WINNER_NUMBERS("당첨 번호를 입력해 주세요."),
    ASK_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    COMMA(","),
    BUY_LOTTO_COUNT_INFO("%d개를 구매했습니다.%n"),
    START_PRIZE_INFO("당첨 통계"),
    NEW_LINE("---"),
    PRIZE_MESSAGE_INFO("%d개 일치 (%s원) - %d개%n"),
    SECOND_PRIZE_INFO("%d개 일치, 보너스 볼 일치 (%s원) - %d개%n"),
    RATE_OF_RETURN_INFO("총 수익률은 %s%%입니다.");

    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    public final String getMessage() {
        return message;
    }
}

