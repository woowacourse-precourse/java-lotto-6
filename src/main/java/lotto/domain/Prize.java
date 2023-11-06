package lotto.domain;

public enum Prize {
    SIX_BALL_MATCHES(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    FIVE_BALL_WITH_BONUS_MATCHES(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIVE_BALL_MATCHES(5, 1_500_000, "5개 일치 (1,500,000원) - "),
    FOUR_BALL_MATCHES(4, 50_000, "4개 일치 (50,000원) - "),
    THREE_BALL_MATCHES(3, 5_000, "3개 일치 (5,000원) - "),
    NO_WINNING_PRIZE(0, 0, "");


    private final int matchingNumbers;
    private final int reward;
    private final String description;

    Prize(int matchingNumbers, int reward, String description) {
        this.matchingNumbers = matchingNumbers;
        this.reward = reward;
        this.description = description;
    }

    public static Prize checkWinningPrize(int matchingNumbers, boolean bonusNumberMatch) {
        if (FIVE_BALL_WITH_BONUS_MATCHES.getMatchingNumbers() == matchingNumbers && bonusNumberMatch) {
            return FIVE_BALL_WITH_BONUS_MATCHES;
        }

        for (Prize prize : values()) {
            if (prize.getMatchingNumbers() == matchingNumbers && prize != FIVE_BALL_WITH_BONUS_MATCHES) {
                return prize;
            }
        }

        return NO_WINNING_PRIZE;
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public int getReward() {
        return reward;
    }

    public String getDescription() {
        return description;
    }
}