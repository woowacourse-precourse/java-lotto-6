package lotto.domain;

import java.util.Arrays;

public enum LottoRank {

    MISS(0, 0, false),
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false);


    private static final String GENERAL_RANK_MESSAGE = "%d개 일치 (%s원) - %d개\n";
    private static final String RANK_MESSAGE_WITH_BONUS = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";

    private final int matchCount;
    private final int winPrice;

    private final boolean bonusNumberMatchNeeded;

    LottoRank(int matchCount, int winPrice, boolean bonusNumberMatchNeeded) {
        this.matchCount = matchCount;
        this.winPrice = winPrice;
        this.bonusNumberMatchNeeded = bonusNumberMatchNeeded;
    }

    public String getLottoRankMessage(int rankCount) {
        if (this == MISS) {
            return "";
        }
        if (this == SECOND) {
            return getFormattedMessage(RANK_MESSAGE_WITH_BONUS, rankCount);
        }
        return getFormattedMessage(GENERAL_RANK_MESSAGE, rankCount);
    }

    private String getFormattedMessage(String messageFormat, int rankCount) {
        String formattedReward = String.format("%,d", winPrice);
        return String.format(messageFormat, matchCount, formattedReward, rankCount);
    }

    private boolean isMatchCountSatisfied(int matchCount) {
        return matchCount == this.matchCount;
    }

    private boolean isBonusNumberMatchSatisfied(boolean bonusNumberMatched) {
        if (this == THIRD && bonusNumberMatched) {
            return false;
        }
        return bonusNumberMatched || !bonusNumberMatchNeeded;
    }

    public int getTotalWinPrice(int rankCount) {
        return rankCount * winPrice;
    }

    public static LottoRank getLottoRank(int matchCount, boolean bonusNumberMatched) {
        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank.isMatchCountSatisfied(matchCount))
                .filter(lottoRank -> lottoRank.isBonusNumberMatchSatisfied(bonusNumberMatched))
                .findFirst()
                .orElse(MISS);
    }
}
