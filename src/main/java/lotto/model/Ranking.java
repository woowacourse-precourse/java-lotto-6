package lotto.model;


public enum Ranking {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(null, 0);

    private final Integer matchCount;
    private final int reward;

    Ranking(Integer matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static Ranking of(int matchCount, boolean isBonus){
        if (matchCount == FIRST.matchCount) {
            return FIRST;
        }

        if (matchCount == SECOND.matchCount) {
            return isBonus ? SECOND : THIRD;
        }

        if (matchCount == FOURTH.matchCount) {
            return FOURTH;
        }

        if (matchCount == FIFTH.matchCount) {
            return FIFTH;
        }

        return NONE;
    }
}
