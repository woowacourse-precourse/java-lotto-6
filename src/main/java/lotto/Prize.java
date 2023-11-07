package lotto;

enum Prize {
    NONE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000), // Note: SECOND prize requires a bonus number match as well.
    FIRST(6, 2_000_000_000);

    private final int matchCount;
    private final int reward;

    Prize(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static Prize valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == 6) {
            return FIRST;
        } else if (matchCount == 5 && matchBonus) {
            return SECOND;
        } else if (matchCount == 5) {
            return THIRD;
        } else if (matchCount == 4) {
            return FOURTH;
        } else if (matchCount == 3) {
            return FIFTH;
        }
        return NONE;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }
}