package lotto;

import domain.LottoPurchaseManager;
import ui.LottoPurchaseConsoleUI;

public class Application {
    public static void main(String[] args) {
        LottoPurchaseManager purchaseManager = new LottoPurchaseManager();
        LottoPurchaseConsoleUI purchaseConsole = new LottoPurchaseConsoleUI(purchaseManager);
        int numOfLottos = purchaseConsole.startPurchaseProcess();


    }
}
