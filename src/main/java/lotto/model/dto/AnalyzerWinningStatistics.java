package lotto.model.dto;

import lotto.model.LottoWinningAnalyzer;

import java.util.List;

public record AnalyzerWinningStatistics(List<WinningResult> winningResults, double yield) {
    public static AnalyzerWinningStatistics fromLottoWinningAnalyzer(LottoWinningAnalyzer lottoWinningAnalyzer) {
        List<WinningResult> winningResults = lottoWinningAnalyzer.calculateSortedWinningResult();
        double yield = lottoWinningAnalyzer.calculateYield(winningResults);
        return new AnalyzerWinningStatistics(winningResults, yield);
    }
}
