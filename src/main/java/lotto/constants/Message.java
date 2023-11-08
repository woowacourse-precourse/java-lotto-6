package lotto.constants;

public enum Message {

    ENTER_PURCHASE_MONEY("구입금액을 입력해 주세요."),
    ENTER_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    ENTER_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    SHOW_WINNING_STATISTICS("당첨 통계\n---"),
    SHOW_PURCHASE_LOTTO("%d개를 구매했습니다.\n"),
    SHOW_EARNING_RATE("총 수익률은 %.1f%%입니다.\n");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
