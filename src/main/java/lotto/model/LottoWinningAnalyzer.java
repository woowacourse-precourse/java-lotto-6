package lotto.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lotto.model.dto.AnalyzerWinningStatistics;
import lotto.model.dto.WinningResult;

public class LottoWinningAnalyzer {
    private final Lottos lottos;
    private final WinningNumbers winningNumbers;

    public LottoWinningAnalyzer(Lottos lottos, WinningNumbers winningNumbers) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
    }

    public AnalyzerWinningStatistics generateWinningStatistics() {
        return AnalyzerWinningStatistics.fromLottoWinningAnalyzer(this);
    }

    public double calculateYield(List<WinningResult> winningResults) {
        double totalIncome = sumPrizeAmount(winningResults);
        double investmentCost = lottos.calculateTotalCost();
        return (totalIncome / investmentCost) * 100;
    }

    public List<WinningResult> calculateSortedWinningResult() {
        List<WinningResult> unsortedWinningResults = calculateWinningResult();
        return sortWinningResultByPriceAmount(unsortedWinningResults);
    }

    private List<WinningResult> calculateWinningResult() {
        return Arrays.stream(WinningRule.values())
                .map(winningRule -> WinningResult.of(winningRule, this))
                .collect(Collectors.toList());
    }

    private List<WinningResult> sortWinningResultByPriceAmount(List<WinningResult> winningResults) {
        return winningResults.stream()
                .sorted(Comparator.comparingLong(WinningResult::getPrizeAmount))
                .collect(Collectors.toList());
    }

    public Map<WinningRule, Integer> countMatchedWinningRules() {
        List<WinningRule> winningRules = matchWinningRules(lottos.getLottos());
        return winningRules.stream()
                .collect(Collectors.toMap(Function.identity(), winningRule -> 1, Integer::sum));
    }

    private long sumPrizeAmount(List<WinningResult> winningResults) {
        return winningResults.stream()
                .mapToLong(WinningResult::calculatePrize)
                .sum();
    }

    private List<WinningRule> matchWinningRules(List<Lotto> lottos) {
        return lottos.stream()
                .map(this::findWinningRule)
                .collect(Collectors.toList());
    }

    private WinningRule findWinningRule(Lotto lotto) {
        int matchCount = winningNumbers.calculateMatchCount(lotto);
        boolean bonusMatch = winningNumbers.isBonusMatch(lotto);
        return WinningRule.of(matchCount, bonusMatch);
    }
}
