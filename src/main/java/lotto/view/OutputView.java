package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.util.ConsoleMessage;
import lotto.util.Constants;
import lotto.util.ResultMessage;

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
            purchasedLottoTickets.append(ResultMessage.NEWLINE).append(numbers.toString());
        }
        System.out.println(purchasedLottoTickets.toString());
    }

    public static void printFinalResult(Map<LottoRank, Integer> winningStatistics, int purchaseAmount) {
        System.out.println(ResultMessage.LOTTO_WINNING_STATISTICS);
        System.out.println(ResultMessage.THREE_HYPHENS);
        printWinningStatistics(winningStatistics);
        printTotalProfitRate(winningStatistics, purchaseAmount);
    }

    public static void printTotalProfitRate(Map<LottoRank, Integer> winningStatistics, int purchaseAmount) {
        List<LottoRank> lottoRanks = getWinningStatsFormat();
        long TotalProfit = 0L;
        for (LottoRank lottoRank : lottoRanks) {
            TotalProfit += (long) lottoRank.getWinningPrize() * winningStatistics.getOrDefault(lottoRank, 0);
        }
        System.out.printf(ResultMessage.TOTAL_PROFIT_FORMAT, ((double) TotalProfit / purchaseAmount * Constants.ONE_HUNDRED));
    }

    public static void printWinningStatistics(Map<LottoRank, Integer> winningStatistics) {
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

    public static void printInputMessage(String message) {
        System.out.println(message);
    }

    public static void printExceptionMessage(String message) {
        System.out.println(message);
    }
}
