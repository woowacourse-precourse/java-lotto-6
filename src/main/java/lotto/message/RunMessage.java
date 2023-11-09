package lotto.message;

public enum RunMessage {

    INPUT_AMOUNT_MESSAGE("구입금액을 입력해 주세요.\n"),
    PRINT_LOTTO_COUNT("\n%d개를 구매했습니다.\n"),
    INPUT_WINNING_MESSAGE("\n당첨 번호를 입력해 주세요.\n"),
    INPUT_BONUS_MESSAGE("\n보너스 번호를 입력해 주세요.\n"),
    PRINT_WINNING_STATISTIC_MESSAGE("\n당첨 통계\n---\n"),
    PRINT_WINNING_FIRST("6개 일치 (2,000,000,000원) - %d개\n"),
    PRINT_WINNING_SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    PRINT_WINNING_THIRD("5개 일치 (1,500,000원) - %d개\n"),
    PRINT_WINNING_FOURTH("4개 일치 (50,000원) - %d개\n"),
    PRINT_WINNING_FIFTH("3개 일치 (5,000원) - %d개\n"),
    PRINT_WINNING_STATISTIC("총 수익률은 %.1f%%입니다.\n");


    private final String message;


    RunMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
