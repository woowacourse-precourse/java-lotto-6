package lotto;

public enum
LottoManagerMsg {
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요.\n"),
    INPUT_BONUS_NUMBERS("보너스 번호를 입력해 주세요.\n"),
    NORMAL_MESSAGE("%d개 일치 (%s원) - %d개\n"),
    SECOND_MESSAGE("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n"),
    TOTAL_RATE_REVENUE_MESSAGE("총 수익률은 %.1f%%입니다.\n"),
    WINNING_STATISTICS_MESSAGE("당첨 통계 \n---\n");

    private String messageType;

    LottoManagerMsg(String type) {
        this.messageType = type;
    }

    public String getDescription() {
        return messageType;
    }
}
