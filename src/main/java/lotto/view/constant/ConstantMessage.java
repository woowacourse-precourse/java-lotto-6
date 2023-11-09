package lotto.view.constant;

public enum ConstantMessage {
    PAY_MONEY("구입금액을 입력해 주세요.\n"),
    BUY_LOTTO("\n%d개를 구매했습니다.\n"),
    WINNING_NUMBER("\n당첨 번호를 입력해 주세요.\n"),
    BONUS_NUMBER("\n보너스 번호를 입력해 주세요.\n"),
    WINNING_STATICS("\n당첨 통계\n---\n"),
    THREE_MATCH("3개 일치 (5,000원) - %d개"),
    FOUR_MATCH("4개 일치 (50,000원) - %d개"),
    FIVE_MATCH("5개 일치 (1,500,000원) - %d개"),
    FIVE_BONUS_MATCH("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    SIX_MATCH("6개 일치 (2,000,000,000원) - %d개"),
    TOTAL_RATE_OF_RETURN("총 수익률은 %s입니다.");
    private final String message;

    ConstantMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
