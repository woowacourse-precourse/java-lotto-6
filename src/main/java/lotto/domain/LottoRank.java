package lotto.domain;

import static lotto.domain.LottoUtils.getMatchCount;

public enum LottoRank {
    FIRST_PLACE(1, 2_000_000_000L, 6),
    SECOND_PLACE(2, 30_000_000L, 5) {
        @Override
        public boolean isMatch(Lotto lotto, WinningNumbers winningNumbers, int matchCount) {
            int bonusNumber = winningNumbers.getBonusNumber();
            boolean containBonusNumber = lotto.getNumbers().contains(bonusNumber);
            return (matchCount == this.getMatchCondition()) && containBonusNumber;
        }
    },
    THIRD_PLACE(3, 1_500_000L, 5),
    FOURTH_PLACE(4, 50_000L, 4),
    FIFTH_PLACE(5, 5_000L, 3),
    NONE(0, 0L, 0) {
        @Override
        public boolean isMatch(Lotto lotto, WinningNumbers winningNumbers, int matchCount) {
            return false;
        }
    };

    private final int rank;
    private final long prize;
    private final int matchCondition;

    LottoRank(int rank, long prize, int matchCondition) {
        this.rank = rank;
        this.prize = prize;
        this.matchCondition = matchCondition;
    }

    public boolean isMatch(Lotto lotto, WinningNumbers winningNumbers, int matchCount) {
        return matchCount == this.getMatchCondition();
    };


    public static LottoRank valueOf(Lotto lotto, WinningNumbers winningNumbers) {
        int matchCount = getMatchCount(lotto.getNumbers(), winningNumbers.getNumbers());

        for (LottoRank rank : LottoRank.values()) {
            if (rank.isMatch(lotto, winningNumbers, matchCount)) {
                return rank;
            }
        }

        return NONE;
    }

    public int getRank() {
        return rank;
    }

    public long getPrize() {
        return prize;
    }

    public int getMatchCondition() {
        return matchCondition;
    }

}
