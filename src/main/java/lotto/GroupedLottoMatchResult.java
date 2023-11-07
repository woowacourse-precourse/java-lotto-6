package lotto;

import static lotto.constants.IntegerConstants.LOTTO_PRICE;
import static lotto.constants.IntegerConstants.MATCH_FIVE_BONUS_REWARD;
import static lotto.constants.IntegerConstants.MATCH_FIVE_REWARD;
import static lotto.constants.IntegerConstants.MATCH_FOUR_REWARD;
import static lotto.constants.IntegerConstants.MATCH_SIX_REWARD;
import static lotto.constants.IntegerConstants.MATCH_THREE_REWARD;

import java.util.List;
import lotto.domain.LottoMatchType;

public class GroupedLottoMatchResult {
    private final List<LottoMatchType> results;

    public GroupedLottoMatchResult(List<LottoMatchType> results) {
        this.results = results;
    }

    public long countMatchResult(LottoMatchType result) {
        return results.stream().filter(r -> r.equals(result)).count();
    }

    public long getTotalProfit() {
        long sum = 0;
        for (var r : results) {
            if (r.equals(LottoMatchType.MATCH_THREE)) {
                sum += MATCH_THREE_REWARD;
            }
            if (r.equals(LottoMatchType.MATCH_FOUR)) {
                sum += MATCH_FOUR_REWARD;
            }
            if (r.equals(LottoMatchType.MATCH_FIVE)) {
                sum += MATCH_FIVE_REWARD;
            }
            if (r.equals(LottoMatchType.MATCH_FIVE_BONUS)) {
                sum += MATCH_FIVE_BONUS_REWARD;
            }
            if (r.equals(LottoMatchType.MATCH_SIX)) {
                sum += MATCH_SIX_REWARD;
            }
        }
        return sum;
    }

    public double getAverageProfit() {
        var total = getTotalProfit();
        return (double) total / results.size();
    }

    public double getProfitRate() {
        return getAverageProfit() / LOTTO_PRICE * 100;
    }
}
