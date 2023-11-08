package lotto.message;

public enum StatisticMessage {
    FIRST_PRIZE_STAT("6개 일치 (2,000,000,000원) - "),
    SECOND_PRIZE_STAT("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD_PRIZE_STAT("5개 일치 (1,500,000원) - "),
    FOURTH_PRIZE_STAT("4개 일치 (50,000원) - "),
    FIFTH_PRIZE_STAT("3개 일치 (5,000원) - ");

    private final String statisticMessage;

    StatisticMessage(String statisticMessage) {
        this.statisticMessage = statisticMessage;
    }

    public String getStatisticMessage() {
        return this.statisticMessage;
    }
}
