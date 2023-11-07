package lotto;


import lotto.v3.controller.LottoPurchaseController;
import lotto.v3.view.LottoPurchaseView;

public class Application {
    public static void main(String[] args) {
        LottoPurchaseController controller = new LottoPurchaseController(new LottoPurchaseView());
        controller.startPurchaseProcess();
    }
}
