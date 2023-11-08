package lotto.view;

import lotto.model.Ranking;

import java.text.MessageFormat;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static final String NEXT_LINE = "\n";
    private static final String LOTTO_FRAME = "[{0}]";
    private static final String DIVIDE_NUMBER = ", ";
    private static final String BUY_LOTTO_COUNT_MESSAGE = NEXT_LINE + "{0}개를 구매했습니다.";
    private static final String WIN_ALARM_MESSAGE = NEXT_LINE + "당첨 통계" + NEXT_LINE + "---";
    private static final String WIN_SECOND_INFORMATION_MESSAGE = "{0}개 일치, 보너스 볼 일치 ({1}원) - {2}개";
    private static final String WIN_INFORMATION_MESSAGE = "{0}개 일치 ({1}원) - {2}개";
    private static final String TOTAL_PROFIT_MESSAGE = "총 수익률은 {0}%입니다.";

    public static void printBuyLottos(List<List<Integer>> lottos, int lottoCount) {
        System.out.println(MessageFormat.format(BUY_LOTTO_COUNT_MESSAGE, lottoCount));
        lottos.forEach(numbers -> System.out.println(formatLottoNumbers(numbers)));
        System.out.print(NEXT_LINE);
    }

    public static void printWinStatistics(double profit, EnumMap<Ranking, Integer> results) {
        System.out.println(WIN_ALARM_MESSAGE);
        System.out.println(formatRank(Ranking.FIFTH, results.get(Ranking.FIFTH)));
        System.out.println(formatRank(Ranking.FOURTH, results.get(Ranking.FOURTH)));
        System.out.println(formatRank(Ranking.THIRD, results.get(Ranking.THIRD)));
        System.out.println(formatRank(Ranking.SECOND, results.get(Ranking.SECOND)));
        System.out.println(formatRank(Ranking.FIRST, results.get(Ranking.FIRST)));
        System.out.println(MessageFormat.format(TOTAL_PROFIT_MESSAGE, String.format("%.1f", profit)));
    }

    private static String formatRank(Ranking rank, int count) {
        if (rank.isSecond()) {
            return MessageFormat.format(WIN_SECOND_INFORMATION_MESSAGE, rank.getMatchCount(), rank.getReward(), count);
        }
        return MessageFormat.format(WIN_INFORMATION_MESSAGE, rank.getMatchCount(), rank.getReward(), count);
    }

    private static String formatLottoNumbers(List<Integer> numbers) {
        return MessageFormat.format(LOTTO_FRAME, numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(DIVIDE_NUMBER)));
    }
}
