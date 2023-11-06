package lotto.view;

import lotto.model.Lottos;

public class OutputView {
    public static void printLottoNumbers(Lottos lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        System.out.println(lottos.getLottosNumbers());
    }

    public static void printResult(String result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(result);
    }

    public static void printProfitPercentage(String result) {
        System.out.printf("총 수익률은 %s입니다.", result);
    }
}
