package lotto.view;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.WinningResult;

public class WinningResultView implements View {
    private static final String PREFIX = "당첨 통계\n---";
    private static final String WINNING_RESULT_OUTPUT = "%d개 일치 (%s원) - %d개";
    private static final String WINNING_RESULT_OUTPUT_WITH_BONUS = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String RATE_OF_RETURN_OUTPUT = "총 수익률은 %.1f%%입니다.";
    private final List<WinningResult> winningResults;
    private final double rateOfReturn;

    public WinningResultView(List<WinningResult> winningResults, double rateOfReturn) {
        this.winningResults = winningResults;
        this.rateOfReturn = rateOfReturn;
    }

    @Override
    public void render() {
        System.out.println(PREFIX);
        System.out.println(outputWinningResult());
        System.out.print(toStringRateOfReturn());
    }

    private String toStringRateOfReturn() {
        return String.format(RATE_OF_RETURN_OUTPUT, rateOfReturn);
    }

    public String outputWinningResult() {
        List<WinningResult> sortedResults = sortWinningResult();

        return sortedResults.stream()
                .map(this::toStringWinningResult)
                .collect(Collectors.joining("\n"));
    }

    private String toStringWinningResult(WinningResult winningResult) {
        if(winningResult.getWinning().isIncludeBonus()) {
            return String.format(WINNING_RESULT_OUTPUT_WITH_BONUS,
                    winningResult.getWinning().getMatchCount(),
                    winningResult.getWinning().getAmount().formatWithCommas(),
                    winningResult.getMatchCount());
        }

        return String.format(WINNING_RESULT_OUTPUT,
                winningResult.getWinning().getMatchCount(),
                winningResult.getWinning().getAmount().formatWithCommas(),
                winningResult.getMatchCount());
    }

    private List<WinningResult> sortWinningResult() {
        List<WinningResult> sortedResults = winningResults.stream()
                .sorted(Comparator.comparing(winningResult -> winningResult.getWinning().getAmount()))
                .toList();
        return sortedResults;
    }
}
