package lotto.contents;

public enum ContentResults {
    THREE_MATCH("3개 일치 (5,000원) - %d개"),
    FOUR_MATCH("4개 일치 (50,000원) - %d개"),
    FIVE_MATCH("5개 일치 (1,500,000원) - %d개"),
    FIVE_WITH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    SIX_MATCH("6개 일치 (2,000,000,000원) - %d개");
    private final String format;

    ContentResults(String format) {
        this.format = format;
    }

    public String getResultMessage(int count) {
        return String.format(this.format, count);
    }
}
