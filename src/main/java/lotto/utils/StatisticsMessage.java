package lotto.utils;

public enum StatisticsMessage {
    STATISTICS("당첨 통계", 0),
    LINE("---", 0),
    THREE("3개 일치 (5,000원) - ", 5000),
    FOUR("4개 일치 (50,000원) - ", 50000),
    FIVE("5개 일치 (1,500,000원) - ", 1500000),
    FIVE_AND_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000),
    SIX("6개 일치 (2,000,000,000원) - ", 2000000000);

    private String message;
    private int value;

    StatisticsMessage(String message, int value) {
        this.message = message;
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public int getValue() {
        return value;
    }

}
