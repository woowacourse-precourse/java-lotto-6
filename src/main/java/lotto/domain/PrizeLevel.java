package lotto.domain;

public enum PrizeLevel {
    THREE_MATCH("3개 일치 (5,000원) - ", 3),
    FOUR_MATCH("4개 일치 (50,000원) - ", 4),
    FIVE_MATCH("5개 일치 (1,500,000원) - ", 5),
    FIVE_MATCH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 7),
    SIX_MATCH("6개 일치 (2,000,000,000원) - ", 6);

    private final String description;
    private final int win;

    PrizeLevel(String description, int win) {
        this.description = description;
        this.win = win;
    }

    public int getWin() {
        return win;
    }

    public String getDescription() {
        return description;
    }
}
