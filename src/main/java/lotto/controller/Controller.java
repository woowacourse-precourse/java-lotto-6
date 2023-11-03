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

    public void purchaseLotto() {
        int amount = Integer.parseInt(InputView.enterPurchaseAmount());
        buyer = purchasingService.purchaseLotto(amount);
    }
}
