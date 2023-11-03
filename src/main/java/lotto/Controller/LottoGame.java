package lotto.Controller;

import lotto.Validator.Validator;
import lotto.View.InputView;

public class LottoGame {
    public void start() {
        System.out.println(parsePurchaseAmount());
    }

    public int parsePurchaseAmount() {
        while (true) {
            try {
                String userInput = InputView.requestLottoPurchaseAmount();
                int purchaseAmount = Validator.validateParseInt(userInput);
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }
}
