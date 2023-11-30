package lotto;

import controller.LottosController;
import controller.PurchaseController;
import controller.WinningController;
import domain.Lottos;
import domain.PurchaseAmount;

public class Application {

    private static final LottosController lottosController = new LottosController();
    private static final PurchaseController purchaseController = new PurchaseController();

    private static final WinningController winningController = new WinningController();
    public static void main(String[] args) {
        initLottos();
    }

    private static void initLottos(){
        PurchaseAmount purchaseAmount = purchaseController.generatePurchaseAmount();
        Lottos lottos = lottosController.start(purchaseAmount);
        winningController.generateWinngingAndBonus(lottos, purchaseAmount.getAmount());
    }
}
