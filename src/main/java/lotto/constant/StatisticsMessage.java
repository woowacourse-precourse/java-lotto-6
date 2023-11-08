package lotto.constant;

public enum StatisticsMessage {
    FIRST_DESCRIPTION("6개 일치 (2,000,000,000원) - "),
    SECOND_DESCRIPTION("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD_DESCRIPTION("5개 일치 (1,500,000원) - "),
    FOURTH_DESCRIPTION("4개 일치 (50,000원) - "),
    FIFTH_DESCRIPTION("3개 일치 (5,000원) - "),
    STATISTICS_INFO("당첨 통계\n---");

    private final String message;

    StatisticsMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getLottoStatisticsDescription(int rankCount) {
        StringBuilder resultMessage = new StringBuilder();
        resultMessage.append(message).append(rankCount).append("개");

        return resultMessage.toString();
    }
}
