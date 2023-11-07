package lotto.controller;

import lotto.domain.LottoPurchaseAmount;
import lotto.view.input.InputView;

public class MainController {
    public static void start() {
        LottoPurchaseAmount lottoPurchaseAmount = readLottoPurchaseAmount();
    }

    private static LottoPurchaseAmount readLottoPurchaseAmount() {
        int lottoPurchasePrice = InputView.readLottoPurchasePrice();
        return LottoPurchaseAmount.from(lottoPurchasePrice);
    }
}
