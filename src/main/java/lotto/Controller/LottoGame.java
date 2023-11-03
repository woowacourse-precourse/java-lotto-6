package lotto.Controller;

import lotto.View.InputView;

public class LottoGame {
    public void setting() {
        String userInput = InputView.requestLottoPurchaseAmount();
        System.out.println(userInput);
    }
}
