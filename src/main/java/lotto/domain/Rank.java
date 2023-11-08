package lotto.domain;

public enum Rank {
    THREE(3, 5000, "3개 일치 (5,000원) - "),
    FOUR(4, 50000, "4개 일치 (50,000원) - "),
    FIVE(5, 1500000, "5개 일치 (1,500,000원) - "),
    FIVE_BONUS(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX(6, 2000000000, "6개 일치 (2,000,000,000원) - ");

    private final int hits;
    private final int prize;
    private final String content;

    Rank(int hits, int prize, String content) {
        this.hits = hits;
        this.prize = prize;
        this.content = content;
    }

    public static Rank getRank(Lotto lotto) {
        for (Rank rank : Rank.values()) {
            if (lotto.getHits() == FIVE_BONUS.hits && lotto.getBonusStatus()) {
                return FIVE_BONUS;
            }
            if (rank.hits == lotto.getHits() && rank != FIVE_BONUS) {
                return rank;
            }
        }
        return null;
    }

    public int getPrize() {
        return prize;
    }

    public String getContent() {
        return content;
    }
}
