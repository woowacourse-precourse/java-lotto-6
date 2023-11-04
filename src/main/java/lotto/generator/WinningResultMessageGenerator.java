package lotto.generator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.lotto.LottoRewardCondition;
import lotto.dto.WinningResults;

public class WinningResultMessageGenerator {

    private static final List<String> WINNING_COUNT_FORMATS = List.of(
            "3개 일치 (5,000원) - %d개\n",
            "4개 일치 (50,000원) - %d개\n",
            "5개 일치 (1,500,000원) - %d개\n",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n",
            "6개 일치 (2,000,000,000원) - %d개\n"
    );
    private static final String PROFIT_RATIO_FORMAT = "총 수익률은 %.1f%%입니다.";
    private static final String MESSAGE_SUMMING_FORMAT = "%s%s";

    private WinningResultMessageGenerator() {
    }

    public static String generate(final WinningResults winningResult) {
        List<Integer> winningCounts = Arrays.stream(LottoRewardCondition.values())
                .filter(LottoRewardCondition::isNotFail)
                .map(winningResult::getRewardCount)
                .toList();
        return createResultMessage(winningResult, winningCounts);
    }

    private static String createResultMessage(final WinningResults winningResults, final List<Integer> winningCounts) {
        String winningCountMessage = createWinningCountMessage(winningCounts);
        String prizePercentageMessage = createProfitRatioMessage(winningResults);
        return String.format(MESSAGE_SUMMING_FORMAT, winningCountMessage, prizePercentageMessage);
    }

    private static String createProfitRatioMessage(final WinningResults winningResults) {
        double profitRatio = winningResults.calculateProfitRatio();
        return String.format(PROFIT_RATIO_FORMAT, profitRatio);
    }

    private static String createWinningCountMessage(final List<Integer> winningCounts) {
        return IntStream.range(0, winningCounts.size())
                .mapToObj(i -> String.format(WINNING_COUNT_FORMATS.get(i), winningCounts.get(i)))
                .collect(Collectors.joining());
    }
}
