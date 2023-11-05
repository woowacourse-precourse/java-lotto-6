package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoResultGenerator {
    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;
    private final long inputMoney;
    private Map<PrizeCondition, Long> prizeResult;
    private long prizeMoney;

    private LottoResultGenerator(WinningNumbers winningNumbers, BonusNumber bonusNumber, long inputMoney) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.inputMoney = inputMoney;
    }

    public static LottoResultGenerator create(WinningNumbers winningNumbers, BonusNumber bonusNumber, long inputMoney) {
        return new LottoResultGenerator(winningNumbers, bonusNumber, inputMoney);
    }

    public Map<PrizeCondition, Long> generatePrizeResult(Lottos lottos) {
        List<PrizeCondition> prizeConditions = lottos.providePrizeConditions(winningNumbers, bonusNumber);
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
