package lotto.view;

import lotto.dto.PurchaseResult;
import lotto.dto.WinningResult;
import lotto.model.Lotto;

import static lotto.view.constant.viewMessage.*;

public class OutputView {

    public void outputPurchaseLottos(PurchaseResult result) {
        System.out.printf(OUTPUT_PURCHASE_RESULT, result.purchaseCount());
        for (Lotto lotto : result.lottos()) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public void outputWinningResult(WinningResult result) {
        System.out.print(OUTPUT_WINNING_STATISTICS_INTRO);

        System.out.printf(
                OUTPUT_WINNING_STATISTICS_RESULT
                , result.rank()[5], result.rank()[4],
                result.rank()[3], result.rank()[2], result.rank()[1]
        );
        System.out.printf(OUTPUT_RATE_OF_RETURN, result.rateOfReturn());
    }
}
