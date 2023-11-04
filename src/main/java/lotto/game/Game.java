package lotto.game;

import lotto.global.Store;
import lotto.ui.Input;
import lotto.ui.Output;

public class Game {
    public void run() {
        int count = Store.convertPriceToCount(Input.getPurchasePrice());
        Output.printPurchaseCount(count);
    }
}
