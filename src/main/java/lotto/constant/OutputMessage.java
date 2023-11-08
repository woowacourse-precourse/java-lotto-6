package lotto.constant;

public enum OutputMessage {
    AMOUNT_COUNT("\n%d개를 구매했습니다.\n")
    , WINNING_STATISTICS("\n당첨 통계\n---")
    , FIFTH_PRIZE("3개 일치 (5,000원) - %d개\n")
    , FOURTH_PRIZE("4개 일치 (50,000원) - %d개\n")
    , THIRD_PRIZE("5개 일치 (1,500,000원) - %d개\n")
    , SECOND_PRIZE("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n")
    , FIRST_PRIZE("6개 일치 (2,000,000,000원) - %d개\n")
    , LOTTO_YIELD("총 수익률은 %s%%입니다.")
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
