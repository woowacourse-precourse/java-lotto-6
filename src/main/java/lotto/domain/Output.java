package lotto.domain;

import java.util.List;

public class Output {

    public static void printLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        for (Lotto lotto : lottos){
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printWinStats(WinStats winstats) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(winstats.toString());
    }

    public static void printEarningsRate(Double rate) {
        System.out.printf("총 수익률은 %.1f%%입니다.", rate);
    }
}
