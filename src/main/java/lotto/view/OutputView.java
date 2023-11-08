package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.WinningStatics;

public class OutputView {
    private static final String PURCHASE_LOTTOS = "\n%d개를 구매했습니다.\n";
    private static final String WINNING_STATICS_PREFIX = "\n당첨 통계\n---\n";
    private static final String RATE_OF_RETURN = "총 수익률은 %.1f%입니다.\n";

    public void printPurchaseLottos(final List<Lotto> lottos) {
        System.out.printf(PURCHASE_LOTTOS, lottos.size());
        printLottos(lottos);
    }

    private void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void printWinningStatics(WinningStatics winningStatics) {
        System.out.print(WINNING_STATICS_PREFIX);
        System.out.println(winningStatics);
    }

    public void printRateOfReturn(float rateOfReturn) {
        System.out.printf(RATE_OF_RETURN, rateOfReturn);
    }
}
