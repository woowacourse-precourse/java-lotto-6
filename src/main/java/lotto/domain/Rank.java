package lotto.domain;

public enum Rank {
    FIRST(6, false, 0, 2000000000, "6개 일치 (2,000,000,000원) - %d개\n"),
    SECOND(5, true, 0, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    THIRD(5, false, 0, 1500000, "5개 일치 (1,500,000원) - %d개\n"),
    FOURTH(4, false, 0, 50000, "4개 일치 (50,000원) - %d개\n"),
    FIFTH(3, false, 0, 5000, "3개 일치 (5,000원) - %d개\n"),
    FAIL(0, false, 0, 0, "");

    private final int lottoMatchCount;
    private final boolean bonusRequired;
    private int winningCount;
    private final int prize;
    private final String prizeText;

    Rank(int lottoMatchCount, boolean bonusRequired, int winningCount, int prize, String prizeText) {
        this.lottoMatchCount = lottoMatchCount;
        this.bonusRequired = bonusRequired;
        this.winningCount = winningCount;
        this.prize = prize;
        this.prizeText = prizeText;
    }

    public static Rank findByMatchCount(int lottoMatchCount, boolean bonusMatched) {
        for (Rank rank : Rank.values()) {
            if (rank.lottoMatchCount == lottoMatchCount && (!rank.bonusRequired || bonusMatched)) {
                return rank;
            }
        }
        return Rank.FAIL;
    }

    public void addCount() {
        this.winningCount += 1;
    }

    public int getCount() {
        return this.winningCount;
    }

    public String getPrizeText() {
        return this.prizeText;
    }

    public int getPrize() {
        return this.prize;
    }
}
