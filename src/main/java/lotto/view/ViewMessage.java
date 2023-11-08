package lotto.view;

public enum ViewMessage {
    /*
    입력 요청 메시지
     */
    REQUEST_INPUT_MONEY("구입금액을 입력해 주세요."),
    REQUEST_WINNER_NUMBERS("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    /*
    출력 관련 메시지
     */
    BOUGHT_LOTTO("\n%d개를 구매했습니다.\n%s\n"),
    WINNER_RESULT("\n당첨 통계\n---\n"),
    PROFIT_RATE("총 수익률은 %.1f%%입니다.");

    private final String message;

    ViewMessage(final String message) {
        this.message = message;
    }

    public String getMessage(Object... args) {
        return String.format(message, args);
    }
}
