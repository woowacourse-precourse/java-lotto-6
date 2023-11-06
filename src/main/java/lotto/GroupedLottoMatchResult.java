package lotto;

import static lotto.constants.IntegerConstants.LOTTO_PRICE;
import static lotto.constants.IntegerConstants.MATCH_FIVE_BONUS_REWARD;
import static lotto.constants.IntegerConstants.MATCH_FIVE_REWARD;
import static lotto.constants.IntegerConstants.MATCH_FOUR_REWARD;
import static lotto.constants.IntegerConstants.MATCH_SIX_REWARD;
import static lotto.constants.IntegerConstants.MATCH_THREE_REWARD;

import java.util.List;

public class GroupedLottoMatchResult {
    private final List<LottoMatchResult> results;

    public GroupedLottoMatchResult(List<LottoMatchResult> results) {
        this.results = results;
    }

    public long countMatchResult(LottoMatchResult result) {
        return results.stream().filter(r -> r.equals(result)).count();
    }

    public long getTotalProfit() {
        long sum = 0;
        for (var r : results) {
            if (r.equals(LottoMatchResult.MATCH_THREE)) {
                sum += MATCH_THREE_REWARD;
            }
            if (r.equals(LottoMatchResult.MATCH_FOUR)) {
                sum += MATCH_FOUR_REWARD;
            }
            if (r.equals(LottoMatchResult.MATCH_FIVE)) {
                sum += MATCH_FIVE_REWARD;
            }
            if (r.equals(LottoMatchResult.MATCH_FIVE_BONUS)) {
                sum += MATCH_FIVE_BONUS_REWARD;
            }
            if (r.equals(LottoMatchResult.MATCH_SIX)) {
                sum += MATCH_SIX_REWARD;
            }
        }
        return sum;
    }

    public double getAverageProfit() {
        var total = getTotalProfit();
        return (double)total / results.size();
    }

    public double getProfitRate() {
        return getAverageProfit() / LOTTO_PRICE * 100;
    }
}
