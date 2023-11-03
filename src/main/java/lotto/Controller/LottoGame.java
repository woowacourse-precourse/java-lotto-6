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
                int lottoQuantity = calculateLottoQuantity(Parser.parsePurchaseAmount(userInput));
                OutputView.printPurchaseLottoAmount(lottoQuantity);
                break;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    private int calculateLottoQuantity(int purchaseAmount) {
        Validator.validateDivisibleBy1000(purchaseAmount);
        return purchaseAmount / LOTTO_PRICE;
    }
}
