package lotto.constants;

public enum OutputMessage {
    OUTPUT_MESSAGE_HOW_MANY_BUY_LOTTOS("\n%d개를 구매했습니다.\n"),
    OUTPUT_MESSAGE("당첨 통계"),
    OUTPUT_MESSAGE_RESULT("%d개 일치"),
    OUTPUT_MESSAGE_BONUS(", 보너스 볼 일치"),
    OUTPUT_MESSAGE_MONEY(" (%s원) - %d개"),
    OUTPUT_MESSAGE_TOTAL_REWARD("총 수익률은 %s%%입니다.");


    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
