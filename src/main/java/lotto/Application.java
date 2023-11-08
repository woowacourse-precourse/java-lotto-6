package lotto;

import lotto.domain.LottoPurchaseManager;
import lotto.model.Lotto;
import lotto.ui.LottoPurchaseConsoleUI;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoPurchaseManager purchaseManager = new LottoPurchaseManager();
        LottoPurchaseConsoleUI purchaseConsole = new LottoPurchaseConsoleUI(purchaseManager);

        int numOfLottos = purchaseConsole.startPurchaseProcess();

        List<Lotto> lottos = purchaseConsole.startPublishProcess(numOfLottos);


    }
}
