package view;

import model.Lotto;
import model.LottoRank;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;

public class ResultView {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.##");
    private static final DecimalFormat PRIZE_FORMAT = new DecimalFormat("#,##0");

    public void displayLottos(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void displayResults(Map<LottoRank, Long> statistics, double profitRate) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        LottoRank[] ranks = {LottoRank.NONE, LottoRank.FIFTH, LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST};

        for (LottoRank rank : ranks) {
            if (rank == LottoRank.NONE) {
                continue;
            }

            Long count = statistics.getOrDefault(rank, 0L);
            String prizeFormatted = PRIZE_FORMAT.format(rank.getPrize());

            if (rank == LottoRank.SECOND) {
                System.out.printf("5개 일치, 보너스 볼 일치 (%s원) - %d개\n", prizeFormatted, count);
            } else {
                System.out.printf("%d개 일치 (%s원) - %d개\n", rank.getMatchCount(), prizeFormatted, count);
            }
        }
        String profitFormatted = DECIMAL_FORMAT.format(profitRate);
        System.out.print("총 수익률은 " + profitFormatted + "%입니다.");
    }
}
