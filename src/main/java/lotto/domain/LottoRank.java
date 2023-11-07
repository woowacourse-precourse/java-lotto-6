package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST_RANK(6, 2_000_000_000),
    SECOND_RANK(-1, 30_000_000),
    THIRD_RANK(5, 1_500_000),
    FOURTH_RANK(4, 50_000),
    FIFTH_RANK(3, 5_000),
    NO_LUCK(2, 0);

    private final int matchNumbers;
    private final int winningAmount;

    LottoRank(int matchNumbers, int winningAmount) {
        this.matchNumbers = matchNumbers;
        this.winningAmount = winningAmount;
    }

    public int getMatchNumbers() {
        return matchNumbers;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public static LottoRank getLottoRank(int matchNumbers) {
        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank.matchNumbers == matchNumbers)
                .findFirst()
                .orElse(null);
    }
}