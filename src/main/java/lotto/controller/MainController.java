package lotto.controller;

import lotto.domain.Customer;
import lotto.domain.LottoPurchaseAmount;
import lotto.domain.RandomLottoFactory;
import lotto.view.input.InputView;

public class MainController {
    public static void start() {
        LottoPurchaseAmount lottoPurchaseAmount = readLottoPurchaseAmount();
        Customer customer = Customer.of(lottoPurchaseAmount, new RandomLottoFactory());
    }

    private static LottoPurchaseAmount readLottoPurchaseAmount() {
        int lottoPurchasePrice = InputView.readLottoPurchasePrice();
        return LottoPurchaseAmount.from(lottoPurchasePrice);
    }
}
