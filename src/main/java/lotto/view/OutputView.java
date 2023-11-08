package lotto.view;

import static lotto.util.GameMessage.*;

public class OutputView {

    public static void printPurchaseAmount(int purchaseAmount) {
        System.out.println(purchaseAmount + PURCHASE_MESSAGE.getMessage());
    }
}
