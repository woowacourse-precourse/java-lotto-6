package lotto.Enum;

import java.util.Arrays;

public enum LottoRankingInfo {
    SIX_MATCH(6, 2000000000),
    FIVE_AND_BONUS(7, 30000000),
    FIVE_MATCH(5, 1500000),
    FOUR_MATCH(4, 50000),
    THREE_MATCH(3, 5000),
    ONE_MATCH(1, 0);

    private final int countWinngNumbers;
    private final int rankWinningPrize;

    LottoRankingInfo(int countWinngNumbers, int rankWinningPrize) {
        this.countWinngNumbers = countWinngNumbers;
        this.rankWinningPrize = rankWinningPrize;
    }

    public int getRankWinningPrize() {
        return rankWinningPrize;
    }

    public static LottoRankingInfo valueOf(int countWinningNumbers) {
        return Arrays.stream(LottoRankingInfo.values())
                .filter(info -> info.countWinngNumbers == countWinningNumbers)
                .findFirst()
                .orElse(null);
    }
}
