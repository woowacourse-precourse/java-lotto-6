package view;

import model.Lotto;
import model.LottoRank;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class ResultView {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.##")

    public static void displayResults(Map<LottoRank, Long> statistics, double profitRate) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        for (LottoRank rank : LottoRank.values()) {
            Long count = statistics.getOrDefault(rank, 0L);
            System.out.printf("%d개 일치 (%s원)- %d개\n", rank.getMatchCount(), DECIMAL_FORMAT.format(rank.getPrize()), count);
        }
        System.out.printf("총 수익률은 " + DECIMAL_FORMAT.format(profitRate) + "%입니다.");
    }
}
