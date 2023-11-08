package lotto.constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum LottoWinningRank {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NO_LUCK(0, false, 0);

    private final int matchingNumberCount;
    private final boolean isBonusNumberMatched;
    private final int winningAmount;

    LottoWinningRank(
            int matchingNumberCount,
            boolean isBonusNumberMatched,
            int winningAmount
    ) {
        this.matchingNumberCount = matchingNumberCount;
        this.isBonusNumberMatched = isBonusNumberMatched;
        this.winningAmount = winningAmount;
    }

    public static LottoWinningRank checkWinningResult(int matchingNumberCount, boolean isBonusNumberMatched) {
        return Arrays.stream(LottoWinningRank.values())
                .filter(lottoWinningRank -> lottoWinningRank.matchingNumberCount == matchingNumberCount)
                .findAny()
                .map(filteringRank -> checkBonusNumberMatched(filteringRank, isBonusNumberMatched))
                .orElse(NO_LUCK);
    }

    private static LottoWinningRank checkBonusNumberMatched(LottoWinningRank rank, boolean isBonusNumberMatched) {
        if (rank != SECOND && rank != THIRD) {
            return rank;
        }

        if (isBonusNumberMatched) {
            return SECOND;
        }

        return THIRD;
    }

    public static List<LottoWinningRank> getLottoWinningRanksIgnoreNoLuck() {
        List<LottoWinningRank> winningRanks = new ArrayList<>(Arrays.asList(LottoWinningRank.values()));
        winningRanks.remove(NO_LUCK);

        return winningRanks;
    }

    public int getMatchingNumberCount() {
        return matchingNumberCount;
    }

    public boolean isBonusNumberMatched() {
        return isBonusNumberMatched;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
