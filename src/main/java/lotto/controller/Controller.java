package lotto.controller;

import java.util.List;
import lotto.domain.Buyer;
import lotto.domain.Game;
import lotto.service.Service;
import lotto.util.Utils;
import lotto.view.Input;
import lotto.view.Output;

public class Controller {
    private final Service service = new Service();

    private Buyer buyer;
    private Game game;

    public void run() {
        beforeGame();
        processGame();
        endGame();
    }

    private void beforeGame() {
        while (true) {
            try {
                buyer = new Buyer(getInputAmount());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        service.purchaseLottos(buyer);
        Output.printPurchasedLottos(buyer);
    }

    private int getInputAmount() {
        Output.printAmountMessage();
        return Utils.stringToInt(Input.getData());
    }

    private void processGame() {
        while (true) {
            try {
                game = new Game(getInputWinningNumbers(), getInputBonusNumber());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> getInputWinningNumbers() {
        Output.printWinningNumberMessage();
        return Utils.stringToIntegerList(Input.getData());
    }

    private int getInputBonusNumber() {
        Output.printBonusNumberMessage();
        return Utils.stringToInt(Input.getData());
    }

    private void endGame() {

    }

}
