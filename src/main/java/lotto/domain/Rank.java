package lotto.domain;

public enum Rank {
    FIRST_PLACE(6, false),
    SECOND_PLACE(5, true),
    THIRD_PLACE(5, false),
    FOURTH_PLACE(4, false),
    FIFTH_PLACE(3, false),
    LAST_PLACE(0, false);

    private final int requiredCount;
    private final boolean bonus;

    Rank(int requiredCount, boolean bonus) {
        this.requiredCount = requiredCount;
        this.bonus = bonus;
    }

    public int getRequiredCount() {
        return requiredCount;
    }

    public boolean isBonus() {
        return bonus;
    }

    public static Rank getByCountAndBonus(int count, boolean bonus) {
        for (Rank rank : values()) {
            if (count == rank.getRequiredCount() && bonus == rank.isBonus()) {
                return rank;
            }
        }
        return LAST_PLACE;
    }
}
