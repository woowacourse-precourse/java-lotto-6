package lotto;


import lotto.v3.controller.LottoGenerationController;
import lotto.v3.controller.LottoPurchaseController;
import lotto.v3.model.LottoMachine;
import lotto.v3.view.LottoGenerateView;
import lotto.v3.view.LottoPurchaseView;

public class Application {
    public static void main(String[] args) {
        LottoPurchaseView purchaseView = new LottoPurchaseView();
        LottoPurchaseController purchaseController = new LottoPurchaseController(purchaseView);

        LottoGenerateView generateView = new LottoGenerateView();
        LottoMachine machine = new LottoMachine();
        LottoGenerationController generationController = new LottoGenerationController(generateView, machine);

        int numberOfTickets = purchaseController.startPurchaseProcess();
        generationController.generateLottoTickets(numberOfTickets);
    }
}
