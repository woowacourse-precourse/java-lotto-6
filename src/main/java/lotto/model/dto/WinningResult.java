package lotto.model.dto;

import java.util.Map;
import lotto.model.LottoWinningAnalyzer;
import lotto.model.WinningRule;

public record WinningResult(WinningRule winningRule, int winningCount) {
    public static WinningResult of(WinningRule winningRule, LottoWinningAnalyzer lottoWinningAnalyzer) {
        Map<WinningRule, Integer> matchedWinningRule = lottoWinningAnalyzer.countMatchedWinningRules();
        int winningCount = matchedWinningRule.getOrDefault(winningRule, 0);
        return new WinningResult(winningRule, winningCount);
    }

    public long getPrizeAmount() {
        return winningRule.getPrizeAmount();
    }

    public long calculatePrize() {
        return winningRule.getPrizeAmount() * winningCount;
    }
}
