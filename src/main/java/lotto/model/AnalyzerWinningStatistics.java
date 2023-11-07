package lotto.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public record AnalyzerWinningStatistics(List<WinningResult> winningResults, double yield) {
    private static final String YIELD_FORMAT = "총 수익률은 %.1f%%입니다.";

    public static AnalyzerWinningStatistics ofSorted(List<WinningResult> unsortedWinningResults, double yield) {
        List<WinningResult> sortedWinningResults = new ArrayList<>(unsortedWinningResults);
        sortedWinningResults.sort(
                Comparator.comparingLong((WinningResult wr) -> wr.winningRule().getPrizeAmount())
        );
        return new AnalyzerWinningStatistics(sortedWinningResults, yield);
    }

    public String formatWinningResults() {
        return winningResults.stream()
                .map(WinningResult::format)
                .collect(Collectors.joining(""));
    }

    public String formatWinningYield() {
        return String.format(YIELD_FORMAT, yield);
    }
}
