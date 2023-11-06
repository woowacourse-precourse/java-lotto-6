package lotto.domain;

import static lotto.domain.Prize.findPrize;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class PrizeResult {

    public static Map<Prize, Long> getPrizeResults(Map<Prize, Long> prizeResults) {
        return Arrays.stream(Prize.values())
                .skip(1)
                .collect(Collectors.toMap(
                        prize -> prize,
                        prize -> prizeResults.getOrDefault(prize, 0L),
                        Long::sum,
                        () -> new TreeMap<>(Comparator.comparing(Enum::ordinal))
                ));
    }

    public static Map<Prize, Long> calculatePrizeResults(Lottos lottos, PlayerLotto playerLotto) {
        return lottos.getLottos().stream()
                .map(lotto -> findPrize(lotto.countMatch(playerLotto), lotto.countBonusMatch(playerLotto)))
                .collect(Collectors.groupingBy(prize -> prize, Collectors.counting()));
    }

    public static Double calculateProfitRate(Integer money, Map<Prize, Long> prizeResults) {
        return (double) calculateNetProfit(money, prizeResults) / (double) money * 100;
    }

    private static Long calculateNetProfit(Integer money, Map<Prize, Long> prizeResults) {
        Long totalProfit =  prizeResults.entrySet().stream()
                .mapToLong(prizeResult -> prizeResult.getKey().getPrizeMoney() * prizeResult.getValue())
                .sum();
        return totalProfit - money;
    }

}
