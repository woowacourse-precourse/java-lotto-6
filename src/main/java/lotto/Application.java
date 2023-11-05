package lotto;

import lotto.view.InputView;
import lotto.vo.Purchase;

public class Application {
    public static void main(String[] args) {
        String amount = InputView.readPurchaseAmount();
        Purchase.createFromInput(amount);
    }
}
