package lotto.domain;

public enum WinningType {
    FIRST("1등", 0, 6, false, 2000000000),
    SECOND("2등", 1, 5, true, 30000000),
    THIRD("3등", 2, 5, false, 1500000),
    FOURTH("4등", 3, 4, false, 50000),
    FIFTH("5등", 4, 3, false, 5000);

    private final String name;
    private final int index;
    private final int matchingCount;
    private final boolean bonusMatching;
    private final int price;

    WinningType(String name, int index, int matchingCount, boolean bonusMatching, int price) {
        this.name = name;
        this.index = index;
        this.matchingCount = matchingCount;
        this.bonusMatching = bonusMatching;
        this.price = price;
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
}
