package lotto.domain;

import java.util.Map;
import java.util.stream.Collectors;
import lotto.config.LottoConfig;

public class LottoResult {
    private final Map<Prize, Long> result;

    private LottoResult(final Map<Prize, Long> result) {
        this.result = result;
    }

    public static LottoResult of(final Lottos lottos, final WinningLotto winningLotto) {
        return new LottoResult(lottos.getLottos().stream()
                .collect(Collectors.groupingBy(winningLotto::rankPrize, Collectors.counting())));
    }

    public Map<Prize, Long> getResult() {
        return result;
    }

    //FIXME: REFACTORING POINT
    public double calculateProfit() {
        long totalWinning = calculateTotalWinning();
        Money totalMoney = calculateTotalMoney();

        double profit = ((double) totalWinning / totalMoney.getValue()) * 100;
        double roundedProfit = Math.round(profit * 100.0) / 100.0;
        
        return roundedProfit;
    }

    private long calculateTotalWinning() {
        long totalWinning = result.entrySet()
                .stream()
                .mapToLong(entry -> entry.getKey().getWinnings() * entry.getValue())
                .sum();
        return totalWinning;
    }

    private Money calculateTotalMoney() {
        long totalQuantity = result.values()
                .stream()
                .mapToLong(Long::longValue)
                .sum();
        return new Money(totalQuantity * LottoConfig.PRICE);
    }

}
