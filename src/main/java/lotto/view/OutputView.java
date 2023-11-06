package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.ResultCalculator;

public class OutputView {
    public static void printIssuedLotto(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResult(ResultCalculator resultCalculator) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(resultCalculator);
        System.out.printf("총 수익률은 %.2f%%입니다.", resultCalculator.getProfitRate());
    }
}
