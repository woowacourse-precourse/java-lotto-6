package lotto.global.util;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;

public final class OutputManager {

    public static void printHistory(int totalCnt, List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.\n", totalCnt);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printWinResult(Map<Integer, Long> winningAmount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf(
                "3개 일치 (5,000원) - %d개\n"
                        + "4개 일치 (50,000원) - %d개\n"
                        + "5개 일치 (1,500,000원) - %d개\n"
                        + "5개 일치, 보너스 불 일치 (30,000,000원) - %d개\n"
                        + "6개 일치 (2,000,000,000원) - %d개\n"
                , winningAmount.get(5_000)
                , winningAmount.get(50_000)
                , winningAmount.get(1_500_000)
                , winningAmount.get(30_000_000)
                , winningAmount.get(2_000_000_000)
        );
    }

    public static void printRateOfProfit(double result) {
        System.out.print("총 수익률은 " + result + "%입니다.");
    }
}
