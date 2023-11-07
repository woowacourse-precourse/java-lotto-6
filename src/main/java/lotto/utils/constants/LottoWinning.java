package lotto.utils.constants;

public enum LottoWinning {

    FIRST_PRIZE(6, false, 2_000_000_000, 1),
    SECOND_PRIZE(5, true, 30_000_000, 2),
    THIRD_PRIZE(5, false, 1_500_000, 3),
    FOURTH_PRIZE(4, false, 50_000, 4),
    FIFTH_PRIZE(3, false, 5_000, 5),
    NO_PRIZE(0, false, 0, 0);

    private final int matchValues;
    private final boolean matchBonus;
    private final int reward;
    private final int rank;

    LottoWinning(final int matchValues, final boolean matchBonus, final int reward, final int rank) {
        this.matchValues = matchValues;
        this.matchBonus = matchBonus;
        this.reward = reward;
        this.rank = rank;
    }

    public int getReward() {
        return reward;
    }

    public int getMatchValues() {
        return matchValues;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public int getRank() {
        return rank;
    }

    public static LottoWinning findByMatchValues(int matchValues) {
        for (LottoWinning winning : values()) {
            if (winning.matchValues == matchValues) {
                return winning;
            }
        }
        return NO_PRIZE;
    }

    public static String formatCurrency(int amount) {
        return String.format("%,d", amount);
    }
}