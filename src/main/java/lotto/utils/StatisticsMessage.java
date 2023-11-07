package lotto.utils;

public enum StatisticsMessage {
    STATISTICS("당첨 통계"),
    LINE("---"),
    THREE("3개 일치 (5,000원) - "),
    FOUR("4개 일치 (50,000원) - "),
    FIVE("5개 일치 (1,500,000원) - "),
    FIVE_AND_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX("6개 일치 (2,000,000,000원) - ");

    private String value;

    StatisticsMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
