package lotto.controller;

import lotto.domain.Buyer;
import lotto.dto.PurchaseResult;
import lotto.service.Service;
import lotto.view.Input;
import lotto.view.Output;

public class Controller {
    private final Service service = new Service();

    public void run() {
        readyForGame();
        proceedGame();
        getResult();
    }

    private void readyForGame() {
        while (true) {
            try {
                Output.printAmountMessage();
                Buyer buyer = new Buyer(Input.inputAmount());
                PurchaseResult purchaseResult = service.purchaseLottos(buyer);
                Output.printPurchasedLottos(purchaseResult);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void purchaseLotto() {

    }

    private void proceedGame() {

    }

    private void getResult() {

    }

}
