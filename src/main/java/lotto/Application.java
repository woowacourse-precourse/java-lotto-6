package lotto;

import controller.LottosController;
import controller.PurchaseController;
import domain.PurchaseAmount;

public class Application {

    private static final LottosController lottosController = new LottosController();
    private static final PurchaseController purchaseController = new PurchaseController();
    public static void main(String[] args) {
        initLottos();
    }

    private static void initLottos(){
        PurchaseAmount purchaseAmount = purchaseController.generatePurchaseAmount();
        lottosController.start(purchaseAmount);
    }
}
