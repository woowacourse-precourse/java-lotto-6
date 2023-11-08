package lotto.model;

public enum Prize {
    FIRST_PRIZE(2000000000, 6, false),
    SECOND_PRIZE(30000000, 5, true),
    THIRD_PRIZE(1500000, 5, false),
    FOURTH_PRIZE(50000, 4, false),
    FIFTH_PRIZE(5000, 3, false),
    NOTHING_PRIZE(0, 2, false);

    private final int prizeMoney;
    private final int matches;
    private final boolean hasBonus;


    Prize(int prizeMoney, int matches, boolean hasBonus) {
        this.prizeMoney = prizeMoney;
        this.matches = matches;
        this.hasBonus = hasBonus;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static Prize getByMatchesAndBonus(int matches, boolean hasBonus) {
        if (matches == 6) {
            return FIRST_PRIZE;
        } else if (matches == 5 && hasBonus) {
            return SECOND_PRIZE;
        } else if (matches == 5) {
            return THIRD_PRIZE;
        } else if (matches == 4) {
            return FOURTH_PRIZE;
        } else if (matches == 3) {
            return FIFTH_PRIZE;
        } else {
            return NOTHING_PRIZE;
        }
    }
}