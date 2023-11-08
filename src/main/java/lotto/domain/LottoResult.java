package lotto.domain;

import static lotto.domain.Prize.findPrize;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class LottoResult {

    private static final int NUM_PRIZES_TO_SKIP = 1;
    private static final Long DEFAULT_ENTRY_VALUE = 0L;
    private static final int HUNDRED = 100;

    private final Map<Prize, Long> prizeResult;

    public LottoResult(final Lottos lottos, final WinnerLotto winnerLotto) {
        this.prizeResult = processPrizeResult(calculatePrizeResult(lottos, winnerLotto));
    }

    public Map<Prize, Long> getPrizeResult() {
        return this.prizeResult;
    }

    public Double calculateProfitRate(Integer money, Map<Prize, Long> prizeResults) {
        return (double) calculateProfit(prizeResults) / (double) money * HUNDRED;
    }

    private Map<Prize, Long> processPrizeResult(Map<Prize, Long> prizeResults) {
        return Arrays.stream(Prize.values())
                .skip(NUM_PRIZES_TO_SKIP)
                .collect(Collectors.toMap(
                        prize -> prize,
                        prize -> prizeResults.getOrDefault(prize, DEFAULT_ENTRY_VALUE),
                        Long::sum,
                        () -> new TreeMap<>(Comparator.comparing(Enum::ordinal))
                ));
    }

    private Map<Prize, Long> calculatePrizeResult(Lottos lottos, WinnerLotto winnerLotto) {
        return lottos.lottos().stream()
                .map(lotto -> findPrize(lotto.countMatch(winnerLotto), lotto.countBonusMatch(winnerLotto)))
                .collect(Collectors.groupingBy(prize -> prize, Collectors.counting()));
    }

    private Long calculateProfit(Map<Prize, Long> prizeResults) {
        return prizeResults.entrySet().stream()
                .mapToLong(prizeResult1 -> prizeResult1.getKey().getPrizeMoney() * prizeResult1.getValue())
                .sum();
    }

}
