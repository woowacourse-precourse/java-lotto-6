package lotto.domain;

public enum Rank {

    FIRST(0,6,2000000000),
    SECOND(1,15,30000000,10),
    THIRD(2,5,1500000),
    FOURTH(3,4,50000),
    FIFTH(4,3,5000);

    private final Integer rankIndex;
    private final Integer matchedCount;
    private final Integer winningPrize;
    private final Integer identifier;

    Rank(Integer rankIndex, Integer matchedCount, Integer winningPrize) {
        this.rankIndex = rankIndex;
        this.matchedCount = matchedCount;
        this.winningPrize = winningPrize;
        identifier = null;
    }

    Rank(Integer rankIndex, Integer matchedCount, Integer winningPrize, Integer identifier) {
        this.rankIndex = rankIndex;
        this.matchedCount = matchedCount;
        this.winningPrize = winningPrize;
        this.identifier = identifier;
    }

    public int getRankIndex() {
        return rankIndex;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getPrize() {
        return winningPrize;
    }

    public int getIdentifier() {
        return identifier;
    }
}
