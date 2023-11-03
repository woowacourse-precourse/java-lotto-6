package lotto.view;


import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    public static void printPurchasedLottoTickets(int amount, LottoTicket lottoTicket) {
        int ticketCount = amount / 1000;
        System.out.printf("%d개를 구매했습니다.\n", ticketCount);
        printLottoNumbers(lottoTicket);
    }

    private static void printLottoNumbers(LottoTicket lottoTicket) {
        lottoTicket.getLottoTickets().forEach(lotto -> System.out.println(formatLottoNumbers(lotto)));
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
        System.out.println("당첨 통계");
        System.out.println("---------");

        long totalPrize = 0;

        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                System.out.printf("%d개 일치", rank.getCountOfMatch());

                if (rank == Rank.SECOND) {
                    System.out.print(", 보너스 볼 일치");
                }

                System.out.printf(" (%s원) - %d개\n", String.format("%,d", rank.getPrize()), statistics.get(rank));

                totalPrize += (long) rank.getPrize() * statistics.get(rank);
            }
        }

        double earningRate = ((double) totalPrize / amount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", earningRate);
    }
}
