package lotto;

import lotto.Controller.Controller;
import lotto.Controller.PurchaseController;

public class Application {
    public static void main(String[] args) {
        Controller purchaseController = new PurchaseController();

        purchaseController.run();
    }
}
