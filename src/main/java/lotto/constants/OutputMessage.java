package lotto.constants;

public enum OutputMessage {
    ASK_AMOUNT_COMMENT("구입금액을 입력해 주세요."),
    LOTTO_BUY_QUANTITY_COMMENT("%d개를 구매했습니다.\n"),
    ASK_WIN_LOTTO_NUMBER_COMMENT("당첨 번호를 입력해 주세요."),
    ASK_BONUS_LOTTO_NUMBER_COMMENT("보너스 번호를 입력해 주세요."),
    RESULT_START_COMMENT("당첨 통계\n----"),
    FIFTH_PRIZE_COMMENT("3개 일치 (5,000원) - %d개\n"),
    FOURTH_PRIZE_COMMENT("4개 일치 (50,000원) - %d개\n"),
    THIRD_PRIZE_COMMENT("5개 일치 (1,500,000원) - %d개\n"),
    SECOND_PRIZE_COMMENT("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    FIRST_PRIZE_COMMENT("6개 일치 (2,000,000,000원) - %d개\n"),
    TOTAL_PROFIT_RATE_COMMENT("총 수익률은 %s%%입니다.\n");
    
    private final String comment;

    OutputMessage(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }
}
