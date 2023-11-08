package lotto;

import lotto.utils.Rank;

import java.util.List;
import java.util.Map;

public class Result {
    public void printNumberOfLottosPurchased(int numberOfLottos) {
        System.out.println(numberOfLottos + "개를 구매했습니다.");
    }

    public void printPurchasedLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers().toString());
        }
    }

    public void printStatistics(Map<Rank, Integer> statistics) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        printRank(statistics, Rank.FIFTH);
        printRank(statistics, Rank.FOURTH);
        printRank(statistics, Rank.THIRD);
        printSecondRank(statistics);
        printRank(statistics, Rank.FIRST);
    }

    private void printRank(Map<Rank, Integer> statistics, Rank rank) {
        System.out.printf("%d개 일치 (%s원)- %d개\n",
                rank.getMatchCount(),
                formatPrize(rank.getPrize()),
                statistics.get(rank));

    }

    private void printSecondRank(Map<Rank, Integer> statistics) {
        System.out.printf("5개 일치, 보너스 볼 일치 (%s원)- %d개\n",
                formatPrize(Rank.SECOND.getPrize()),
                statistics.get(Rank.SECOND));

    }

    private String formatPrize(int prize) {
        return String.format("%,d", prize);
    }

    public void printProfitRate(double profitRate) {
        String formattedProfitRate = formatProfitRate(profitRate);
        System.out.printf("총 수익률은 %s%%입니다.\n", formattedProfitRate);
    }

    private String formatProfitRate(double profitRate) {
        if (profitRate % 1.0 == 0) {
            return String.valueOf((int)profitRate);
        }
        return String.format("%.2f", profitRate);
    }
}
