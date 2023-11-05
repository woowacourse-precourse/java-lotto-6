package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoResultGenerator {
    private final WinningLotto winningLotto;
    private final long inputMoney;
    private Map<PrizeCondition, Long> prizeResult;
    private long prizeMoney;

    private LottoResultGenerator(WinningLotto winningLotto, long inputMoney) {
        this.winningLotto = winningLotto;
        this.inputMoney = inputMoney;
    }

    public static LottoResultGenerator create(WinningLotto winningLotto, long inputMoney) {
        return new LottoResultGenerator(winningLotto, inputMoney);
    }

    public Map<PrizeCondition, Long> generatePrizeResult(Lottos lottos) {
        List<PrizeCondition> prizeConditions = lottos.providePrizeConditions(winningLotto);
        prizeResult = prizeConditions.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return prizeResult;
    }

    public double generateProfit() {
        calculatePrizeMoney();
        double profit = (double) prizeMoney / inputMoney;
        return Math.round(profit * 10) / 10.0;
    }

    private void calculatePrizeMoney() {
        for (PrizeCondition prizeCondition : prizeResult.keySet()) {
            prizeMoney += prizeCondition.getPrize() * prizeResult.get(prizeCondition);
        }
    }
}
