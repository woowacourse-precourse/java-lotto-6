package lotto.view;

import lotto.dto.PurchaseResult;
import lotto.model.Lotto;

public class OutputView {

    public void outputPurchaseLottos(PurchaseResult result) {
        System.out.printf("%d개를 구매했습니다.\n", result.purchaseCount());
        for (Lotto lotto : result.lottos()) {
            System.out.println(lotto);
        }
    }
}
