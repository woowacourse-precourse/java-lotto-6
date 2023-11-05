package lotto.enums;

public enum Rank {
    FIRST(6,false),
    SECOND(5,true),
    THIRD(5,false),
    FOURTH(4,false),
    FIFTH(3,false);

    private final int matchCount;
    private final boolean containBonus;

    Rank(int matchCount, boolean containBonus) {
        this.matchCount = matchCount;
        this.containBonus = containBonus;
    }

    public int getMatchedCount() {
        return this.matchCount;
    }

    public boolean containsBonus() {
        return this.containBonus;
    }
}
