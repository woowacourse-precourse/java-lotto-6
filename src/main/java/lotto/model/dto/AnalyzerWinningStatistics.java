package lotto.model.dto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.model.LottoWinningAnalyzer;

public record AnalyzerWinningStatistics(List<WinningResult> winningResults, double yield) {
    public static AnalyzerWinningStatistics ofSorted(List<WinningResult> unsortedWinningResults, double yield) {
        List<WinningResult> sortedWinningResults = new ArrayList<>(unsortedWinningResults);
        sortedWinningResults.sort(
                Comparator.comparingLong(WinningResult::getPrizeAmount)
        );
        return new AnalyzerWinningStatistics(sortedWinningResults, yield);
    } // TODO : 없애기

    public static AnalyzerWinningStatistics fromLottoWinningAnalyzer(LottoWinningAnalyzer lottoWinningAnalyzer) {
        List<WinningResult> winningResults = lottoWinningAnalyzer.calculateSortedWinningResult();
        double yield = lottoWinningAnalyzer.calculateYield(winningResults);
        return new AnalyzerWinningStatistics(winningResults, yield);
    }
}
