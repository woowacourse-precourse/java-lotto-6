package lotto.view;

import lotto.constant.Message;
import lotto.domain.PurchaseLottos;

public class OutputView {
    public void printPurchaseLottos(PurchaseLottos purchaseLottos) {
        printNewLine();
        System.out.println(purchaseLottos.getPurchaseCount() + Message.PURCHASE_COUNT.getMessage());
        System.out.println(purchaseLottos.getPurchaseLottos());
    }

    private void printNewLine() {
        System.out.println();
    }

}
