package lotto.view;

import static lotto.view.LottoGameMessage.REQUEST_PURCHASE_AMOUNT;

public class ConsoleOutputView {
    public void requestPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT.getMessage());
    }
}
