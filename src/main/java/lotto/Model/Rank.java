package lotto.Model.VO;

public enum Rank {
    FIRST(6, 0),
    SECOND(5, 1),
    THIRD(5, 0),
    FOURTH(4, 0),
    FIFTH(3, 0);

    private final int matchCount;
    private final int bonus;

    Rank(int matchCount, int bonus) {
        this.matchCount = matchCount;
        this.bonus = bonus;
    }
}
