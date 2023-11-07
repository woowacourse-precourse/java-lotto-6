package lotto.view;

import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.dto.AnalyzerWinningStatistics;
import lotto.model.dto.BuyerLottoHistory;
import lotto.model.dto.WinningResult;

public class OutputFormatter {
    private static final String LOTTO_COUNT_FORMAT = "개를 구매했습니다.";
    private static final String LOTTOS_DELIMITER = "\n";
    private static final String LOTTO_NUMBERS_DELIMITER = ", ";
    private static final String LOTTO_NUMBERS_PREFIX = "[";
    private static final String LOTT_NUMBERS_SUFFIX = "]";
    private static final String YIELD_FORMAT = "총 수익률은 %.1f%%입니다.";
    private static final String COUNT_PREFIX = " - ";
    private static final String COUNT_SUFFIX = "개\n";

    public static String formatBuyerLottoCount(BuyerLottoHistory buyerLottoHistory) {
        return buyerLottoHistory.lottoCount() + LOTTO_COUNT_FORMAT;
    }

    public static String formatBuyerLottos(BuyerLottoHistory buyerLottoHistory) {
        return buyerLottoHistory.lottos().stream()
                .map(OutputFormatter::formatLottoNumbers)
                .collect(Collectors.joining(LOTTOS_DELIMITER));
    }

    public static String formatAnalyzerWinningResults(AnalyzerWinningStatistics analyzerWinningStatistics) {
        return analyzerWinningStatistics.winningResults().stream()
                .map(OutputFormatter::formatWinningResult)
                .collect(Collectors.joining(""));
    }

    public static String formatAnalyzerWinningYield(AnalyzerWinningStatistics analyzerWinningStatistics) {
        return String.format(YIELD_FORMAT, analyzerWinningStatistics.yield());
    }

    private static String formatLottoNumbers(Lotto lotto) {
        return lotto.getNumbers().stream()
                .map(Object::toString)
                .collect(Collectors.joining(LOTTO_NUMBERS_DELIMITER, LOTTO_NUMBERS_PREFIX, LOTT_NUMBERS_SUFFIX));
    }

    private static String formatWinningResult(WinningResult winningResult) {
        return winningResult.winningRule().getDescription()
                + COUNT_PREFIX
                + winningResult.winningCount()
                + COUNT_SUFFIX;
    }
}
