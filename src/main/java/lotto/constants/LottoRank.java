package lotto.constants;

import lotto.domain.MatchingResult;

import java.util.Arrays;

public enum LottoRank {

    FIRST(1, 6, false, 2_000_000_000),
    SECOND(2, 5, true, 30_000_000),
    THIRD(3, 5, false, 1_500_000),
    FOURTH(4, 4, false, 50_000),
    FIFTH(5, 3, false, 5_000),
    NONE(0, 2, false, 0);

    private final int rank;

    private final int correctCount;

    private final boolean isBonusCorrect;
    private final int prizeMoney;

    LottoRank(int rank, int correctCount, boolean isBonusCorrect, int prizeMoney) {
        this.rank = rank;
        this.correctCount = correctCount;
        this.isBonusCorrect = isBonusCorrect;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank from(MatchingResult result) {
        if (result.isSecondWinner()) {
            return SECOND;
        }

        if (result.isThirdWinner()) {
            return THIRD;
        }

        return Arrays.stream(values())
                .filter((lottoRank) -> lottoRank.correctCount == result.getCorrectCount())
                .findAny()
                .orElse(NONE);
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public String getFormattedPrizeMoney() {
        return String.format("%,d", prizeMoney);
    }

    public int getRank() {
        return rank;
    }

    public boolean isBonusCorrect() {
        return isBonusCorrect;
    }
}
