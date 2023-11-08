package lotto.domain.lottoResult;

import java.util.Arrays;

public enum LottoRank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchNumber;
    private final long winningAmount;

    LottoRank(int matchNumber, long winningAmount) {
        this.matchNumber = matchNumber;
        this.winningAmount = winningAmount;
    }

    public static LottoRank ofMatchNumber(final int matchNumber, boolean isBonus) {
        LottoRank lottoRank = findMatchNumber(matchNumber);

        if (lottoRank == SECOND) {
            if (isBonus) {
                return SECOND;
            }
            return THIRD;
        }
        return lottoRank;
    }

    private static LottoRank findMatchNumber(final int matchNumber) {
        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank.matchNumber == matchNumber)
                .findFirst()
                .orElse(NONE);
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public long getWinningAmount() {
        return winningAmount;
    }
}
