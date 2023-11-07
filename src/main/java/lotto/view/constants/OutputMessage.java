package lotto.view.constants;

public enum OutputMessage {
    INPUT_PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),

    PURCHASE_MESSAGE("%d개를 구매했습니다."),
    WINNING_STATISTICS_MESSAGE("당첨 통계\n---"),
    WINNING_MESSAGE("%d개 일치 (%s) - %d개"),
    WINNING_BONUS_MESSAGE("%d개 일치, 보너스 볼 일치 (%s) - %d개"),
    RESULT_MESSAGE("총 수익률은 %.1f%%입니다.");


    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
