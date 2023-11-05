package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoResultGenerator {
    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    private LottoResultGenerator(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static LottoResultGenerator create(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        return new LottoResultGenerator(winningNumbers, bonusNumber);
    }

    public Map<PrizeCondition, Long> generatePrizeResult(Lottos lottos) {
        List<PrizeCondition> prizeConditions = lottos.providePrizeConditions(winningNumbers, bonusNumber);
        return prizeConditions.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public double generateProfit() {
        //TODO profit 계산 후 리턴
        return 0;
    }

    private void calculatePrizeMoney() {
        //TODO 전체 수익 금액 계산
//        for (PrizeCondition prizeCondition : prizeFrequencies.keySet()) {
//            prizeMoney += prizeCondition.getPrize() * prizeFrequencies.get(prizeCondition);
//        }
    }
}
