package lotto.message;

public enum GameMessage {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    WINNING_NUMBER("\n당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    LOTTO_AMOUNT("\n%d개를 구매했습니다."),
    RESULT_STATISTICS("\n당첨 통계\n---"),
    PROFIT_PERCENTAGE("총 수익률은 %.1f%%입니다.");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
