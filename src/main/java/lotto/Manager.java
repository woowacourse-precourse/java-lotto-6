package lotto;

import lotto.view.Input;
import lotto.view.Output;

public class Manager {
    private final Input input = new Input();
    private final Output output = new Output();

    public void getAmountToPurchase() {
        output.printEnteringAmountPrompt();
        int purchasedAmount = input.readTotalPurchasedAmount();
    }
}
