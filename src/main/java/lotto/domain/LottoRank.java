package lotto.domain;

import java.util.List;
public enum LottoRank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);

    private int matchCount;
    private int prizeAmount;

    LottoRank(int matchCount, int prizeAmount) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public static LottoRank calculateRank(List<Integer> ticketNumbers, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = (int) ticketNumbers.stream()
                .filter(winningNumbers::contains)
                .count();

        if (matchCount == 5) {
            return determineSecondOrThird(ticketNumbers, bonusNumber);
        }

        for (LottoRank rank : LottoRank.values()) {
            if (rank.getMatchCount() == matchCount) {
                return rank;
            }
        }

        return NONE;
    }

    private static LottoRank determineSecondOrThird(List<Integer> ticketNumbers, int bonusNumber) {
        if (ticketNumbers.contains(bonusNumber)) {
            return SECOND;
        }
        return THIRD;
    }

}

