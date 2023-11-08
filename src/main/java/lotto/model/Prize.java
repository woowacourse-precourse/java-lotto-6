package lotto.model;

import java.nio.channels.Pipe;

public enum Prize {
    FIRST_PRIZE(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    SECOND_PRIZE(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD_PRIZE(5, 1_500_000, "5개 일치 (1,500,000원) - "),
    FOURTH_PRIZE(4, 50_000, "4개 일치 (50,000원) - "),
    FIFTH_PRIZE(3, 5_000, "3개 일치 (5,000원) - "),
    NOTHING(0,0,"");

    Prize(int numberMatches, int prizeOfLottery, String message) {
        this.numberMatches = numberMatches;
        this.prizeOfLottery = prizeOfLottery;
        this.message = message;
    }

    private static final int MINIMUM_WINNING_COUNT = 3;

    private int numberMatches;
    private int prizeOfLottery;
    private String message;

    public static Prize getPrize(int numberMatchCount, boolean bonusCheck) {
        if (SECOND_PRIZE.getNumberMatches() == numberMatchCount && bonusCheck) {
            return SECOND_PRIZE;
        }

        for (Prize prize : values()) {
            if (prize.getNumberMatches() == numberMatchCount && prize != SECOND_PRIZE)
                return prize;
        }

        return NOTHING;
    }

    public int getNumberMatches() {
        return numberMatches;
    }

    public int getPrizeOfLottery() {
        return prizeOfLottery;
    }

    public String getMessage() {
        return message;
    }
}