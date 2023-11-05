package lotto;

import lotto.view.InputView;
import lotto.vo.Purchase;

public class Application {
    public static void main(String[] args) {
        Purchase purchase = InputView.inputPurchase();
    }
}
