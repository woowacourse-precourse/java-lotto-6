package lotto.Message;

public enum OutputViewMessage {
    PURCHASED_LOTTO_COUNT("\n%d를 구매하셨습니다."),
    WINNING_STATS("\n당첨 통계\n---"),
    RESULT_5TH_PRIZE("3개 일치 (5,000원) - %d개"),
    RESULT_4TH_PRIZE("4개 일치 (50,000원) - %d개"),
    RESULT_3RD_PRIZE("5개 일치 (1,500,000원) - %d개"),
    RESULT_2ND_PRIZE("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    RESULT_1ST_PRIZE("6개 일치 (2,000,000,000원) - %d개"),
    EARNING_RATE("총 수익률은 %f입니다.");

    private String message;

    OutputViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
