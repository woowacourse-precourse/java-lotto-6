package lotto.constant;

import java.util.Arrays;

public enum LottoWinningRank {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000);

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
                .filter(lottoWinningRank -> lottoWinningRank.matchingNumberCount == matchingNumberCount
                        && lottoWinningRank.isBonusNumberMatched == isBonusNumberMatched)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 당첨 기준이 존재하지 않습니다."));
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
