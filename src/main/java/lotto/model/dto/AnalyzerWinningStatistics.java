package lotto.model.dto;

import java.util.List;
import lotto.model.LottoWinningAnalyzer;

public record AnalyzerWinningStatistics(List<WinningResult> winningResults, double yield) {
    public static AnalyzerWinningStatistics fromLottoWinningAnalyzer(LottoWinningAnalyzer lottoWinningAnalyzer) {
        List<WinningResult> winningResults = lottoWinningAnalyzer.calculateSortedWinningResult();
        double yield = lottoWinningAnalyzer.calculateYield(winningResults);
        return new AnalyzerWinningStatistics(winningResults, yield);
    }
}
