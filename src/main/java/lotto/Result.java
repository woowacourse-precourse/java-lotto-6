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
        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) {
                continue; // 'NONE' 등수는 출력하지 않음
            }
            System.out.printf("%d개 일치 (%d원)- %d개\n",
                    rank.getMatchCount(),
                    rank.getPrize(),
                    statistics.getOrDefault(rank, 0));
        }
    }

    public void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.2f%%입니다.\n", profitRate);
    }
}
