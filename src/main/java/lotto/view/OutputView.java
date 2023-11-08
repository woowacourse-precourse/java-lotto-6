package lotto.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Statistics;

public class OutputView {
    private static final String STATISTICS_FORMAT = "%d개 일치 (%s원) - %d개";
    private static final String STATISTICS_FORMAT_WITH_BONUS = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";

    public static void printLottoTickets(List<Lotto> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        lottoTickets.forEach(OutputView::printLotto);
    }

    public static void printLotto(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        Collections.sort(lottoNumbers);
        System.out.println(lottoNumbers);
    }

    public static void printStatistics(Statistics statistics) {
        printStatisticsBeginMessage();
        Map<Rank, Integer> winningResult = statistics.getWinningResult();
        for (Rank rank : getRanksToPrint()) {
            printStatistic(rank, winningResult.get(rank));
        }

    }

    private static void printStatisticsBeginMessage() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    private static List<Rank> getRanksToPrint() {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.MISS)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    private static void printStatistic(Rank rank, Integer count) {
        int countOfMatch = rank.getCountOfMatch();
        int winningMoney = rank.getWinningMoney();
        if (rank.equals(Rank.SECOND)) {
            System.out.printf(STATISTICS_FORMAT_WITH_BONUS, countOfMatch, winningMoney, count);
        }
        System.out.printf(STATISTICS_FORMAT, countOfMatch, winningMoney, count);
        System.out.println();
    }
}
