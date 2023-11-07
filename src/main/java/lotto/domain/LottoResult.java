package lotto.domain;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.config.LottoConfig;
import lotto.constants.Prize;

public class LottoResult {
    private final Map<Prize, Long> result;
    private static final Double PERCENTAGE = 100.0;

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

    public double calculateProfit() {
        long totalWinning = calculateTotalWinning();
        Money totalMoney = calculateTotalMoney();
        double profit = ((double) totalWinning / totalMoney.getBudget()) * PERCENTAGE;
        return Math.round(profit * PERCENTAGE) / PERCENTAGE;
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
