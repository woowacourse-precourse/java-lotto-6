package lotto;

public enum WinningResult {
    THREE_MATCH("3개 일치 (5,000원)", 5000, 0),
    FOUR_MATCH("4개 일치 (50,000원)", 50000, 1),
    FIVE_MATCH("5개 일치 (1,500,000원)", 1500000, 2),
    BONUS_MATCH("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000, 3),
    SIX_MATCH("6개 일치 (2,000,000,000원)", 2000000000, 4);

    private final String phrase;
    private int count;
    private final int price;

    WinningResult(String phrase, int price, int order) {
        this.phrase = phrase;
        this.price = price;
        this.count = 0;
    }

    public String getPhrase() {
        return phrase;
    }

    public int getCount() {
        return count;
    }

    public void incrementCount() {
        count++;
    }

    public static long calculateTotalAmount() {
        long total = 0;
        for (WinningResult result : values()) {
            total += result.count * result.price;
        }
        return total;
    }
}
