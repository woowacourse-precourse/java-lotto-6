package lotto.model.dto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public record AnalyzerWinningStatistics(List<WinningResult> winningResults, double yield) {
    public static AnalyzerWinningStatistics ofSorted(List<WinningResult> unsortedWinningResults, double yield) {
        List<WinningResult> sortedWinningResults = new ArrayList<>(unsortedWinningResults);
        sortedWinningResults.sort(
                Comparator.comparingLong((WinningResult wr) -> wr.winningRule().getPrizeAmount())
        );
        return new AnalyzerWinningStatistics(sortedWinningResults, yield);
    }
}
