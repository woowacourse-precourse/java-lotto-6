package lotto.domain;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.config.LottoConfig;

public class LottoResult {
    private final Map<Prize, Long> result;

    private LottoResult(final Map<Prize, Long> result) {
        this.result = Collections.unmodifiableMap(result);
    }

    public static LottoResult of(final Lottos lottos, final WinningLotto winningLotto) {
        return new LottoResult(lottos.getPackOfLotteryTickets().stream()
                .collect(Collectors.groupingBy(winningLotto::rankPrize, Collectors.counting())));
    }

    public Map<Prize, Long> getResult() {
        return result;
    }

    //FIXME: REFACTORING POINT
    public double calculateProfit() {
        long totalWinning = calculateTotalWinning();
        Money totalMoney = calculateTotalMoney();

        double profit = ((double) totalWinning / totalMoney.getBudget()) * 100;
        return Math.round(profit * 100.0) / 100.0;
    }

    private long calculateTotalWinning() {
        return result.entrySet()
                .stream()
                .mapToLong(entry -> entry.getKey().getWinnings() * entry.getValue())
                .sum();
    }

    private Money calculateTotalMoney() {
        long totalQuantity = result.values()
                .stream()
                .mapToLong(Long::longValue)
                .sum();
        return new Money(totalQuantity * LottoConfig.PRICE);
    }

}
