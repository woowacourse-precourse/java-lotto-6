package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoResultGenerator {
    private final WinningLotto winningLotto;
    private final LottoPurchaseAmount purchaseAmount;
    private Map<PrizeCondition, Long> prizeResult;

    private LottoResultGenerator(WinningLotto winningLotto, LottoPurchaseAmount purchaseAmount) {
        this.winningLotto = winningLotto;
        this.purchaseAmount = purchaseAmount;
    }

    public static LottoResultGenerator create(WinningLotto winningLotto, LottoPurchaseAmount purchaseAmount) {
        return new LottoResultGenerator(winningLotto, purchaseAmount);
    }

    public Map<PrizeCondition, Long> generatePrizeResult(Lottos lottos) {
        List<PrizeCondition> prizeConditions = lottos.providePrizeConditions(winningLotto);
        prizeResult = prizeConditions.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return prizeResult;
    }

    public double generateProfit() {
        long prizeMoney = calculatePrizeMoney();
        double profit = (double) prizeMoney / purchaseAmount.getAmount() * 100;
        return Math.round(profit * 10) / 10.0;
    }

    private long calculatePrizeMoney() {
        return prizeResult.keySet().stream()
                .mapToLong(prizeCondition -> prizeCondition.getPrize() * prizeResult.get(prizeCondition))
                .sum();
    }
}
