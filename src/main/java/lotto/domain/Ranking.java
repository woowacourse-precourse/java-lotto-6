package lotto.domain;

public enum Ranking {
    FIRST(6, 6, 2_000_000_000),
    SECOND(7, 5, 30_000_000),
    THIRD(5, 5, 1_500_000),
    FOURTH(4, 4, 50_000),
    FIFTH(3, 3, 5_000),
    FIND(1, 0, 0);

    private final int idx;
    private final int matchedCount;
    private final int price;

    Ranking(int idx, int matchedCount,int price) {
        this.idx = idx;
        this.matchedCount = matchedCount;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public Ranking valueOf(int label) {
        for (Ranking winning : Ranking.values()) {
            if (label == winning.idx) {
                return winning;
            }
        }

        return null;
    }

}
