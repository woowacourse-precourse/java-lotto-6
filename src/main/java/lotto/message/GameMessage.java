package lotto.message;

public final class GameMessage {

    public static final String MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String BUY_MESSAGE = "%d개를 구매했습니다.";
    public static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    public static final String WINNING_STATISTICS_HEADER_MESSAGE = "당첨 통계\n---";
    public static final String WINNING_NUMBER_MATCH_MESSAGE = "%d개 일치 (%s원) - %d개";
    public static final String BONUS_NUMBER_MATCH_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    public static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    private GameMessage() {
    }
}
