package lotto.domain;

public enum Rank {

    NONE(0, 0, "0", false, false),
    FIFTH(3, 5_000, "3개 일치 (5,000원) - ", false, true),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - ", false, true),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - ", false, true),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - ", true, true),
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - ", false, true);

    private final int matchCount;
    private final long prize;
    private final String prizeMessage;
    private final boolean isBonus;
    private final boolean isPrint;

    Rank(int matchCount, long prize, String prizeMessage, boolean isBonus, boolean isPrint) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.prizeMessage = prizeMessage;
        this.isBonus = isBonus;
        this.isPrint = isPrint;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrize() {
        return prize;
    }

    public boolean isBonus() {
        return isBonus;
    }

    public String getPrizeMessage() {
        return prizeMessage;
    }

    public boolean isPrint() {
        return isPrint;
    }
}