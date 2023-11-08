package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.NumbersComparator;
import lotto.Lotto;
import lotto.calculator.PrizeCalculator;
import lotto.calculator.PrizeCounter;
import lotto.calculator.ProfitabilityCalculator;

public class LottoStatistics {

    private double profitability;
    Map<String, Integer> count = new HashMap<>();

    //allLottoNumbers, winningNumbers 가 param 으로 요구됨.
    private NumbersComparator numbersComparator;
    private PrizeCalculator prizeCalculator;
    private PrizeCounter prizeCounter;
    private ProfitabilityCalculator profitabilityCalculator;

    public LottoStatistics(List<Lotto> allLottoNumbers, List<Integer> winningNumbers, int amountOfMoney) {


        this.numbersComparator = new NumbersComparator(allLottoNumbers, winningNumbers);

        this.prizeCalculator = new PrizeCalculator(numbersComparator.getWinningCount(), numbersComparator.getBonusCount());
        this.prizeCounter = new PrizeCounter(prizeCalculator);

        this.profitabilityCalculator = new ProfitabilityCalculator(amountOfMoney, prizeCalculator);

        this.profitability = profitabilityCalculator.calculateProfitability();
        this.count = prizeCounter.countPrize(prizeCalculator.getPrizes());
    }

    public double getProfitability() {
        return profitability;
    }

    public Map<String, Integer> getCount() {
        return count;
    }
}
