package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoResultGenerator {
    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;
    private Map<PrizeCondition, Long> prizeFrequencies;
    private long prizeMoney;
    private long profit;

    private LottoResultGenerator(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static LottoResultGenerator create(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        return new LottoResultGenerator(winningNumbers, bonusNumber);
    }

    public void computePrizeFrequencies(Lottos lottos) {
        List<PrizeCondition> prizeConditions = lottos.providePrizeConditions(winningNumbers, bonusNumber);
        prizeFrequencies = prizeConditions.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public void calculateProfit() {

    }

    private void calculatePrizeMoney() {

    }
}
