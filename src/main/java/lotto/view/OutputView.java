package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.util.ConsoleMessage;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printLottoTicketNumber(int lottoTicketNumber) {
        System.out.printf(ConsoleMessage.LOTTO_TICKET_NUMBER, lottoTicketNumber);
    }

    public static void printPurchasedLottoTickets(List<Lotto> lottos) {
        StringBuilder purchasedLottoTickets = new StringBuilder();
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            purchasedLottoTickets.append('\n').append(numbers.toString());
        }
        System.out.println(purchasedLottoTickets.toString());
    }

    public static void printFinalResult(Map<LottoRank, Integer> winningStatistics) {
        printWinningStatistics(winningStatistics);
    }

    public static void printWinningStatistics(Map<LottoRank, Integer> winningStatistics) {
        System.out.println("당첨 통계");
        System.out.println("---");
        List<LottoRank> lottoRanks = getWinningStatsFormat();
        StringBuilder winningStatisticsResult = new StringBuilder();
        for (LottoRank lottoRank : lottoRanks) {
            winningStatisticsResult
                    .append(String.format(lottoRank.getMessage(), winningStatistics.getOrDefault(lottoRank, 0)));
        }
        System.out.println(winningStatisticsResult);
    }

    private static List<LottoRank> getWinningStatsFormat() {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank != LottoRank.MISS)
                .toList();
    }
}
