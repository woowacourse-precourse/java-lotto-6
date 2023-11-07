package lotto.constant;

public enum ViewMessage {
    ASK_PURCHASE_AMOUNT("구입금액을 입력해 주세요.\n"),
    ASK_WINNING_NUMBER ("당첨 번호를 입력해 주세요.\n"),
    ASK_BONUS_NUMBER ("보너스 번호를 입력해 주세요.\n"),
    PRINT_PURCHASE_AMOUNT("%d개를 구매했습니다.\n"),
    PRINT_PURCHASE_NUMBER("[%s]\n"),
    PRINT_WINNING_STAT("당첨 통계\n---\n"),
    PRINT_MATCHES("%d개 일치 (%s원) - %d개\n"),
    PRINT_BONUS_MATCHES("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n"),
    PRINT_YIELD_RATE ("총 수익률은 %.1f%%입니다.\n"),
    PRINT_SEPARATOR(", ")
    ;

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
