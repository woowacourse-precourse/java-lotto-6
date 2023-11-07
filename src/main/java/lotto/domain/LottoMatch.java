package lotto.domain;

import java.util.List;
import lotto.constants.IntegerConstants;
import lotto.constants.StringConstants;

public class LottoMatch {
    private final List<LottoMatchType> matchResult;

    public LottoMatch(LottoPurchase purchase, LottoWinning winning, LottoBonus bonus) {
        this.matchResult = purchase.matchAll(winning.getWinnings(), bonus.getBonus());
    }

    public long getMatchCount(LottoMatchType type) {
        return matchResult.stream().filter(t -> t == type).count();
    }

    public String getStatusString(LottoMatchType type) {
        var matchCount = getMatchCount(type);
        if (type == LottoMatchType.MATCH_FIVE_BONUS) {
            return String.format(StringConstants.MATCH_RESULT_WITH_BONUS_MESSAGE.toString(),
                    IntegerConstants.MATCH_TYPE_TO_NUMBER_MAP.get(type),
                    IntegerConstants.MATCH_TYPE_TO_REWARD_MAP.get(type), matchCount);
        }
        return String.format(StringConstants.MATCH_RESULT_MESSAGE.toString(),
                IntegerConstants.MATCH_TYPE_TO_NUMBER_MAP.get(type),
                IntegerConstants.MATCH_TYPE_TO_REWARD_MAP.get(type), matchCount);
    }

    public long getTotalProfit() {
        long sum = 0;
        for (var type : matchResult) {
            sum += IntegerConstants.MATCH_TYPE_TO_REWARD_MAP.get(type);
        }
        return sum;
    }

    public double getAverageProfit() {
        var total = getTotalProfit();
        return (double) total / matchResult.size();
    }

    public double getProfitRate() {
        return getAverageProfit() / IntegerConstants.LOTTO_PRICE * 100;
    }

}
