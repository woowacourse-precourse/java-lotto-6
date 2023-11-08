package lotto.domain;

import java.util.Arrays;

public enum Rank {
    NONE(0, 0, false),
    FIFTH(5_000, 3, false),
    FOURTH(50_000, 4, false),
    THIRD(1_500_000, 5, false),
    SECOND(30_000_000, 5, true),
    FIRST(2_000_000_000, 6, false);


    private static final int MIN_COUNT = 3;
    private int prizeAmount;
    private int matchWinning;
    private boolean matchBonus;

    Rank(int prizeAmount,int matchWinning, boolean matchBonus) {
        this.prizeAmount = prizeAmount;
        this.matchWinning = matchWinning;
        this.matchBonus = matchBonus;
    }

    public static Rank calculate(int countWinning, boolean matchBonusNum) {
        return Arrays.stream(Rank.values())
                .filter(rank -> checkLottoRank(rank, countWinning, matchBonusNum))
                .findAny()
                .orElse(NONE);
    }

    private static boolean checkLottoRank(Rank rank, int countWinning, boolean matchBonusNum) {
        if (rank.matchWinning != countWinning) {
            return false;
        }
        if (SECOND.matchWinning == countWinning) {
            return rank.matchBonus == matchBonusNum;
        }
        return true;
    }

    public int getMatchLottoNumber() {
        return matchWinning;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}
