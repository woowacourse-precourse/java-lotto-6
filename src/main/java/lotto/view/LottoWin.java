package lotto.view;

public enum LottoWin {
    THREE_MATCH(1, "3개 일치 (5,000원)"),
    FOUR_MATCH(2, "4개 일치 (50,000원)"),
    FIVE_MATCH(3, "5개 일치 (1,500,000원)"),
    FIVE_MATCH_WITH_BONUS(4, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX_MATCH(5, "6개 일치 (2,000,000,000원)");

    private final int prize;
    private final String description;

    LottoWin(int prize, String description) {
        this.prize = prize;
        this.description = description;
    }

    public int getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }
}
