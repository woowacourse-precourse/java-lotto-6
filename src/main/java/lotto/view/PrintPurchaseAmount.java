package lotto.view;

import lotto.model.PurchaseAmountLotto;

public class PrintPurchaseAmount {
    public static void printPurchaseAmount(PurchaseAmountLotto purchaseAmountLotto) {
        System.out.printf("%d개를 구매했습니다.", purchaseAmountLotto.getPurchaseLotto());
        System.out.println();
    }
}
