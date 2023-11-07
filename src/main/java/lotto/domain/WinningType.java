package lotto.domain;

public enum WinningType {
    FIRST("1등", 0, 6, false, 2000000000L),
    SECOND("2등", 1, 5, true, 30000000L),
    THIRD("3등", 2, 5, false, 1500000L),
    FOURTH("4등", 3, 4, false, 50000L),
    FIFTH("5등", 4, 3, false, 5000L);

    private final String name;
    private final int index;
    private final int matchingCount;
    private final boolean bonusMatching;
    private final long prize;

    WinningType(String name, int index, int matchingCount, boolean bonusMatching, long prize) {
        this.name = name;
        this.index = index;
        this.matchingCount = matchingCount;
        this.bonusMatching = bonusMatching;
        this.prize = prize;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean getBonusMatching() {
        return bonusMatching;
    }

    public long getPrize() {
        return prize;
    }
}
