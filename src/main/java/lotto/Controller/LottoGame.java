package lotto.Controller;

import lotto.Validator.Validator;
import lotto.View.InputView;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;

    public void start() {
        System.out.println(calculateTicketQuantity(parsePurchaseAmount()));
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

    private int calculateTicketQuantity(int purchaseAmount) {
        Validator.validateDivisibleBy1000(purchaseAmount);
        return purchaseAmount / LOTTO_PRICE;
    }
}
