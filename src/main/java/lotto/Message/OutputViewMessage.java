package lotto.Message;

public enum OutputViewMessage {
    PURCHASED_LOTTO_COUNT("\n%d를 구매하셨습니다."),
    WINNING_STATS("\n당첨 통계\n---"),
    RESULT_WITHOUT_BONUS("%d개 일치 (%d원) - %d개"),
    RESULT_WITH_BONUS("%d개 일치, 보너스 볼 일치 (%d원) - %d개"),
    EARNING_RATE("총 수익률은 %f입니다.");

    private String message;

    OutputViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(int numberCount, int award, int prizeCount) {
        return String.format(message, numberCount, award, prizeCount);
    }

    public String getMessage(int number) {
        return String.format(message, number);
    }

    public String getMessage(float number) {
        return String.format(message, number);
    }
}
