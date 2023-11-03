package lotto.view;

import lotto.constant.OutputViewConstant;
import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    public static void printPurchasedLottoTickets(int amount, LottoTickets lottoTickets) {
        int ticketCount = amount / OutputViewConstant.LOTTO_PRICE;
        System.out.printf(OutputViewConstant.PURCHASED_LOTTO_TICKETS_MESSAGE, ticketCount);
        printLottoNumbers(lottoTickets);
    }

    private static void printLottoNumbers(LottoTickets lottoTickets) {
        lottoTickets.getLottoTickets().forEach(lotto -> System.out.println(formatLottoNumbers(lotto)));
        System.out.println();
    }

    private static String formatLottoNumbers(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        return numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    public static void printStatistics(Map<Rank, Integer> statistics, int amount) {
        printHeader();
        long totalPrize = calculateAndPrintRankDetails(statistics);
        printEarningRate(totalPrize, amount);
    }

    private static void printHeader() {
        System.out.println(OutputViewConstant.WINNING_STATISTICS_HEADER);
        System.out.println(OutputViewConstant.SEPARATOR);
    }

    private static long calculateAndPrintRankDetails(Map<Rank, Integer> statistics) {
        long totalPrize = 0;

        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                totalPrize += printRankDetail(rank, statistics.get(rank));
            }
        }

        return totalPrize;
    }

    private static long printRankDetail(Rank rank, Integer count) {
        long prize = rank.getPrize();
        System.out.printf(OutputViewConstant.RANK_MATCH_FORMAT, rank.getCountOfMatch());

        if (rank == Rank.SECOND) {
            System.out.print(OutputViewConstant.BONUS_BALL_TEXT);
        }

        System.out.printf(OutputViewConstant.STATISTICS_FORMAT, String.format("%,d", prize), count);

        return prize * count;
    }

    private static void printEarningRate(long totalPrize, int amount) {
        double earningRate = ((double) totalPrize / amount) * OutputViewConstant.PERCENTAGE;
        System.out.printf(OutputViewConstant.TOTAL_EARNING_RATE_FORMAT, earningRate);
    }
}
