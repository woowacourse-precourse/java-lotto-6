package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.OutputLottoResult;

import java.util.Arrays;
import java.util.List;

public class OutputView {

    public static void printAttempt(int cash) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.\n", cash / 1000);
    }

    public static void printLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(Arrays.toString(lotto.getNumbers().toArray()));
        }
    }

    public static void printStat(OutputLottoResult outputLottoResult) {
        System.out.println();
        System.out.println("당첨 통계\n" +
                "---");

        System.out.printf("3개 일치 (5,000원) - %d개\n", outputLottoResult.getMatch3());
        System.out.printf("4개 일치 (50,000원) - %d개\n", outputLottoResult.getMatch4());
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", outputLottoResult.getMatch5());
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", outputLottoResult.getMatch5AndBonus());
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", outputLottoResult.getMatch6());
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.printf("총 수익률은 %.1f%%입니다.", rateOfReturn);
    }
}
