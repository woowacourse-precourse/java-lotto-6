package lotto.constants;


public enum ResponseMessages {
    END_BUY_MESSAGE("개를 구매했습니다."),
    WIN_STATS_MESSAGE("당첨 통계"),
    LINE_MESSAGE("---"),
    WIN_MESSAGE_5("3개 일치 (5,000원) - "),
    WIN_MESSAGE_4("4개 일치 (50,000원) - "),
    WIN_MESSAGE_3("5개 일치 (1,500,000원) - "),
    WIN_MESSAGE_2("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    WIN_MESSAGE_1("6개 일치 (2,000,000,000원) - "),
    PROFIT_MESSAGE("총 수익률은 ");

    private final String message;

    ResponseMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
