package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.Game;
import lotto.dto.PurchaseResult;
import lotto.service.Service;
import lotto.view.Input;
import lotto.view.Output;

public class Controller {
    private final Service service = new Service();

    public void run() {
        readyForGame();
        proceedGame();
        endGame();
    }

    private void readyForGame() {
        while (true) {
            try {
                Output.printAmountMessage();
                Buyer buyer = new Buyer(Input.getData());
                PurchaseResult purchaseResult = service.purchaseLottos(buyer);
                Output.printPurchasedLottos(purchaseResult);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void proceedGame() {
        Game game = generateGame();
        setBonusNumber(game);
    }

    private Game generateGame() {
        while (true) {
            try {
                Output.printWinningNumberMessage();
                return new Game(Input.getData());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void setBonusNumber(Game game) {
        while (true) {
            try {
                Output.printBonusNumberMessage();
                game.setBonusNumber(Input.getData());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void endGame() {

    }

}
