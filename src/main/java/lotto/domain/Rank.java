package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIRST_PLACE(6, false, 2000000000),
    SECOND_PLACE(5, true, 30000000),
    THIRD_PLACE(5, false, 1500000),
    FOURTH_PLACE(4, false, 50000),
    FIFTH_PLACE(3, false, 5000),
    NOTHING(0, false, 0);

    private int matchedNumber;
    private boolean hasBonusNumber;
    private int winningPrice;

    Rank(int matchedNumber, boolean hasBonusNumber, int winningPrice) {
        this.matchedNumber = matchedNumber;
        this.hasBonusNumber = hasBonusNumber;
        this.winningPrice = winningPrice;
    }

    public static Rank findRankByMatchedNBonusNumber(int matchedNumber, boolean hasBonusNumber) {
        Rank findRank = Arrays.stream(Rank.values())
                .filter(rank -> rank.getMatchedNumber() == matchedNumber)
                .findAny()
                .orElse(Rank.NOTHING);

        if (findRank == Rank.SECOND_PLACE || findRank == Rank.THIRD_PLACE) {
            return getSecondOrThirdRank(hasBonusNumber);
        }
        return findRank;
    }

    private static Rank getSecondOrThirdRank(boolean hasBonusNumber) {
        if (hasBonusNumber) {
            return Rank.SECOND_PLACE;
        }
        return Rank.THIRD_PLACE;
    }

    public int getMatchedNumber() {
        return matchedNumber;
    }

    public int getWinningPrice() {
        return winningPrice;
    }
}
