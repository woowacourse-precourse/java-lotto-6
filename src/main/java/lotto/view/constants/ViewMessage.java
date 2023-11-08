package lotto.view.constants;

public enum ViewMessage {
    PAY_AMOUNT_INPUT("구입금액을 입력해 주세요."),
    PURCHASED_LOTTO("%d개를 구매했습니다.\n"),
    WINNING_NUMBER_INPUT("\n당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT("\n보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("\n당첨 통계\n--- "),
    LOTTO_RESULT("%s - %d개\n"),
    RATE_OF_RETURN("총 수익률은 %.1f%%입니다.\n");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
