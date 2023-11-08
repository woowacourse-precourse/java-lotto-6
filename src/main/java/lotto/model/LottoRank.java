package lotto.model;

import static lotto.common.Constant.MATCH_COUNT_FIVE;
import static lotto.common.Constant.MATCH_COUNT_FOUR;
import static lotto.common.Constant.MATCH_COUNT_SIX;
import static lotto.common.Constant.MATCH_COUNT_THREE;

public enum LottoRank {
    THREE_MATCHES("3개 일치 (5,000원)", MATCH_COUNT_THREE, 5000),
    FOUR_MATCHES("4개 일치 (50,000원)", MATCH_COUNT_FOUR, 50000),
    FIVE_MATCHES("5개 일치 (1,500,000원)", MATCH_COUNT_FIVE, 1500000),
    FIVE_MATCHES_WITH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원)", MATCH_COUNT_FIVE, 30000000),
    SIX_MATCHES("6개 일치 (2,000,000,000원)", MATCH_COUNT_SIX, 2000000000);

    private final String description;
    private final int matchCount;
    private final int reward;

    LottoRank(String description, int matchCount, int reward) {
        this.description = description;
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static LottoRank valueOf(int matchCount, boolean hasBonus) {
        if (hasBonus && matchCount == MATCH_COUNT_FIVE) {
            return FIVE_MATCHES_WITH_BONUS;
        }
        for (LottoRank rank : values()) {
            if (rank.getMatchCount() == matchCount && rank != FIVE_MATCHES_WITH_BONUS) {
                return rank;
            }
        }
        return null;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }

    public String getDescription() {
        return description;
    }
}