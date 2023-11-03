package lotto.controller;

import lotto.domain.Buyer;
import lotto.service.PurchasingService;
import lotto.view.InputView;

public class Controller {

    private PurchasingService purchasingService = new PurchasingService();
    private Buyer buyer;

    public void run() {
     purchaseLotto();

    }

    private void purchaseLotto() {
        String amount = InputView.enterPurchaseAmount();
        buyer = purchasingService.purchaseLotto(amount);
    }
}
