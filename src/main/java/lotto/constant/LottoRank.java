package lotto.constant;

import java.util.stream.Stream;

public enum LottoRank {
    OUT_RANK(0, -1),
    THREE_MATCH(5000, 3),
    FOUR_MATCH(50000, 4),
    FIVE_MATCH(1500000, 5),
    FIVE_AND_BONUS_MATCH( 30000000, 5),
    SIX_MATCH(2000000000, 6);

    private final int prizeMoney;
    private final int matchedNumberCount;

    LottoRank(int prizeMoney, int matchedNumberCount) {
        this.prizeMoney = prizeMoney;
        this.matchedNumberCount = matchedNumberCount;
    }

    public static LottoRank findByMatchedNumberCountAndBonusNumberMatched(
            int matchedNumberCount, boolean bonusNumberMatched
    ) {
        if (matchedNumberCount == 5) {
            return decideRankSecondOrThird(bonusNumberMatched);
        }
        return Stream.of(values())
                .filter(lottoRank -> lottoRank.matchedNumberCount == matchedNumberCount)
                .findAny()
                .orElse(OUT_RANK);
    }

    private static LottoRank decideRankSecondOrThird(boolean matchedBonusNumber) {
        if (matchedBonusNumber) {
            return FIVE_AND_BONUS_MATCH;
        }
        return FIVE_MATCH;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getMatchedNumberCount() {
        return matchedNumberCount;
    }
}
