package lotto.message;

public enum MessageFormat {
    NUMBER_OF_TICKETS_PURCHASED("%d개를 구매했습니다.%n"),
    THREE_MATCH("3개 일치 (5,000원) - %d개%n", 5000),
    FOUR_MATCH("4개 일치 (50,000원) - %d개%n", 50000),
    FIVE_MATCH("5개 일치 (1,500,000원) - %d개%n", 1500000),
    FIVE_MATCH_WITH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", 30000000),
    SIX_MATCH("6개 일치 (2,000,000,000원) - %d개%n", 2000000000),
    TOTAL_YIELDS("총 수익률은 %.1f%%입니다.%n");

    private String format;
    private int amount;

    MessageFormat(String format) {
        this.format = format;
    }
    MessageFormat(String format, int amount) {
        this.format = format;
        this.amount = amount;
    }
    public String getFormat() {
        return format;
    }

    public int getAmount(){
        return amount;
    }

}
