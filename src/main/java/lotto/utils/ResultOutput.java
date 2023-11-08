package lotto.utils;

import java.util.Map;
import lotto.controller.WinningResult;
import lotto.model.Rank;

public class ResultOutput {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printPurchaseQuantityMessage(int quantity) {
        System.out.printf("%d개를 구매했습니다.%n", quantity);
    }

    public static void printPurchaseLotto(String lottos) {
        System.out.println(lottos);
    }

    public static void printWinStatisticsMessage() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printLottoResult(WinningResult lottoResult) {
        Map<Rank, Integer> result = lottoResult.getResult();

        printWinStatisticsMessage();
        Rank[] rank = Rank.values();
        for (int i = rank.length - 2; i >= 0; i--) {
            int count = result.getOrDefault(rank[i], 0);
            if (i == 1) {
                System.out.println(
                        String.format("%d개 일치, 보너스 볼 일치 (%,d원) - %d개", rank[i].getMatchCount(), rank[i].getPrize(),
                                count));
            }
            if (i != 1) {
                System.out.println(
                        String.format("%d개 일치 (%,d원) - %d개", rank[i].getMatchCount(), rank[i].getPrize(), count));
            }
        }
    }

    public static void printProfit(double profit) {
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", profit));
    }

    public static void printErrorMessage(String e) {
        System.out.println(e);
    }
}
