package lotto.view;

import lotto.dto.PurchaseResult;
import lotto.dto.WinningResult;
import lotto.model.Lotto;

public class OutputView {

    public void outputPurchaseLottos(PurchaseResult result) {
        System.out.printf("%d개를 구매했습니다.\n", result.purchaseCount());
        for (Lotto lotto : result.lottos()) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public void outputWinningResult(WinningResult result) {
        System.out.print("당첨 통계\n---\n");

        System.out.printf(
                "3개 일치 (5,000원) - %d개\n"
                + "4개 일치 (50,000원) - %d개\n"
                + "5개 일치 (1,500,000원) - %d개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"
                + "6개 일치 (2,000,000,000원) - %d개\n"
                , result.rank()[5], result.rank()[4],
                result.rank()[3], result.rank()[2], result.rank()[1]
        );
        System.out.printf("총 수익률은 %.1f%%입니다.", result.rateOfReturn());
    }
}
