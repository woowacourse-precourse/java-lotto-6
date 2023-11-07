package lotto;

public enum WinningResult {
    THREE_MATCH("3개 일치 (5,000원)", 0),
    FOUR_MATCH("4개 일치 (50,000원)", 1),
    FIVE_MATCH("5개 일치 (1,500,000원)", 2),
    BONUS_MATCH("5개 일치, 보너스 볼 일치 (30,000,000원)", 3),
    SIX_MATCH("6개 일치 (2,000,000,000원)", 4);

    private final String phrase;
    private int count;

    WinningResult(String phrase, int order) {
        this.phrase = phrase;
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
}
