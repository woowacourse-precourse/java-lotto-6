package lotto.view;

public enum PrintMessage {
    INPUT_MONEY("구입금액을 입력해 주세요."),
    INPUT_ANSWER_LOTTO("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_LOTTO("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계"),
    WINNING_STATISTICS_HEADER("---"),
    EMPTY(""),
    BUY_AMOUNT_FORMAT("%d개를 구매했습니다."),
    WINNING_FORMAT("%d개 일치 (%d원) - %d개"),
    WINNING_BONUS_FORMAT("%d개 일치, 보너스 볼 일치 (%d원) - %d개"),

    RATE_FORMAT("총 수익률은 %.2f입니다.");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
