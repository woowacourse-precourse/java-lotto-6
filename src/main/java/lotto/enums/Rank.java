package lotto.enums;

public enum Rank {
    FIRST(6, false),
    SECOND(5, true),
    THIRD(5, false),
    FOURTH(4, false),
    FIFTH(3, false);

    private final int countMatch;
    private final boolean bonus;

    Rank(int countMatch, boolean bonus) {
        this.countMatch = countMatch;
        this.bonus = bonus;
    }

    public boolean isMatchBonus(int count, boolean bonus) {
        if (count == 5) {
            return this.bonus == bonus;
        }

        return this.countMatch == count;
    }
}
