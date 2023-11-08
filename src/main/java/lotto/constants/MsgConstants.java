package lotto.constants;

public enum MsgConstants {
    PLEASE_ENTER_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASED_SOME_PIECES("\n%d개를 구매했습니다."),
    PLEASE_ENTER_WINNING_NUMBER("\n당첨 번호를 입력해 주세요."),
    PLEASE_ENTER_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("\n당첨 통계\n---"),
    WINNING_STATISTICS_RESULT_SECOND_PRIZE("%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
    WINNING_STATISTICS_RESULT_PRIZE("%d개 일치 (%s원) - %d개"),
    WINNING_STATISTICS_RESULT_RATIO("총 수익률은 %.1f%%입니다.");


    private final String message;

    MsgConstants(String message) {
        this.message = message;
    }

    public String getData() {
        return message;
    }
}