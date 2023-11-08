package lotto.system;

public enum SystemMessage {
    INPUT_MONEY("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    NUMBER_SEPARATOR(","),
    EMPTY(""),
    OUTPUT_PURCHASED_LOTTOS("\n%d개를 구매했습니다.\n"),
    OUTPUT_WINNING_STATS("\n당첨 통계\n---"),
    OUTPUT_PROFIT_MARGIN("총 수익률은 %s%%입니다."),
    WINNING_STAT_MASSAGE_FORMAT("%s - %d개");

    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
