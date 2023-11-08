package lotto.view;

import lotto.Result;

public class OutputView {
    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto));
    }

    public static void printResult(Result result) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        System.out.printf("3개 일치 (5000원) - %d개\n", result.getCountOfMatch3());
        System.out.printf("4개 일치 (50000원) - %d개\n", result.getCountOfMatch4());
        System.out.printf("5개 일치 (1500000원) - %d개\n", result.getCountOfMatch5());
        System.out.printf("5개 일치, 보너스 볼 일치 (30000000원) - %d개\n", result.getCountOfMatch5WithBonus());
        System.out.printf("6개 일치 (2000000000원) - %d개\n", result.getCountOfMatch6());

        System.out.printf("총 수익률은 %.1f%%입니다.\n", result.calculateProfit(LottoStore.LOTTO_PRICE));
    }
}
