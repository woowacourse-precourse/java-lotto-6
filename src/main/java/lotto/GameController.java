
package lotto;

import lotto.ui.InputView;
import lotto.ui.OutputMessage;
import lotto.ui.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        int amount = setAmount();
    }

    private int setAmount() {
        outputView.displayMessage(OutputMessage.GET_AMOUNT_MESSAGE);
        int amount = inputView.getAmount();
        return amount;
    }
}