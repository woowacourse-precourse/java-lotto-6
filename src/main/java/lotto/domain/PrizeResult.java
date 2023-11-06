package lotto.domain;

import static lotto.domain.Prize.findPrize;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class PrizeResult {

    private final Map<Prize, Long> prizeResult;

    public PrizeResult(final Lottos lottos, final WinnerLotto winnerLotto) {
        this.prizeResult = processPrizeResult(calculatePrizeResult(lottos, winnerLotto));
    }

    public Map<Prize, Long> getPrizeResult() {
        return this.prizeResult;
    }

    private Map<Prize, Long> processPrizeResult(Map<Prize, Long> prizeResults) {
        return Arrays.stream(Prize.values())
                .skip(1)
                .collect(Collectors.toMap(
                        prize -> prize,
                        prize -> prizeResults.getOrDefault(prize, 0L),
                        Long::sum,
                        () -> new TreeMap<>(Comparator.comparing(Enum::ordinal))
                ));
    }

    private Map<Prize, Long> calculatePrizeResult(Lottos lottos, WinnerLotto winnerLotto) {
        return lottos.getLottos().stream()
                .map(lotto -> findPrize(lotto.countMatch(winnerLotto), lotto.countBonusMatch(winnerLotto)))
                .collect(Collectors.groupingBy(prize -> prize, Collectors.counting()));
    }

    public Double calculateProfitRate(Integer money, Map<Prize, Long> prizeResults) {
        return (double) calculateProfit(money, prizeResults) / (double) money * 100;
    }

    private Long calculateProfit(Integer money, Map<Prize, Long> prizeResults) {
        Long totalProfit =  prizeResults.entrySet().stream()
                .mapToLong(prizeResult -> prizeResult.getKey().getPrizeMoney() * prizeResult.getValue())
                .sum();
        return totalProfit;
    }

}
