package lotto.Controller;

import lotto.Parser;
import lotto.Validator.Validator;
import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;

    public void start() {
        while (true) {
            try {
                String userInput = InputView.requestLottoPurchaseAmount();
                OutputView.printPurchaseLottoAmount(calculateTicketQuantity(Parser.parsePurchaseAmount(userInput)));
                break;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    private int calculateTicketQuantity(int purchaseAmount) {
        Validator.validateDivisibleBy1000(purchaseAmount);
        return purchaseAmount / LOTTO_PRICE;
    }
}
