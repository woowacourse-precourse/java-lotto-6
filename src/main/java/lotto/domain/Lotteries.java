package lotto.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;

public class Lotteries {

    private final List<Lotto> lotteries;

    private Lotteries(final List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }

    public static Lotteries from(final List<Lotto> lotteries) {
        return new Lotteries(lotteries);
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }

    public BigDecimal calculateTotalWinningPrice(final UserLotto userLotto) {
        int sum = lotteries.stream()
                .map(userLotto::calculateRank)
                .mapToInt(Rank::getPrice)
                .sum();
        return BigDecimal.valueOf(sum);
    }

    public Map<Rank, Integer> calculateTotalRankCount(final UserLotto userLotto) {
        Map<Rank, Integer> result = new HashMap<>();
        for (Rank rank : getRanks(userLotto)) {
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return result;
    }

    private List<Rank> getRanks(final UserLotto userLotto) {
        return lotteries.stream()
                .map(userLotto::calculateRank)
                .filter(Rank::isNotNone)
                .toList();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lotteries) {
            sb.append(lotto).append("\n");
        }
        return sb.toString();
    }
}
