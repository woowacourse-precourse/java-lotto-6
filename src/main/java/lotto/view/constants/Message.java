package lotto.view.constants;

public enum Message {
    INPUT_LOTTO_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASED_LOTTOS_COUNT("%d개를 구매했습니다."),
    PURCHASED_LOTTO_NUMBERS("[%d, %d, %d, %d, %d, %d]"),
    INPUT_WINNING_LOTTO_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_BALL_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS_HEADER("당첨 통계"),
    WINNING_STATISTICS_DIVIDER("---"),
    WINNING_LOTTOS_COUNT_PER_PRIZE("%s - %d개"),
    PROFIT_RATE("총 수익률은 %.1f%%입니다.");

    private final String value;

    Message(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public String getValue(Object... args) {
        return String.format(this.value, args);
    }
}
