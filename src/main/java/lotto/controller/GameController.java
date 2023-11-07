package lotto.controller;

import lotto.service.AmountCalculator;
import lotto.view.InputView;

public class GameController {
    private String amount;
    private int NumberOfLottoPurchased;

    public void play() {
        getAmount();
    }

    private void getAmount() {
        amount = InputView.AMOUNT.getInput();
        AmountCalculator amountCalculator = new AmountCalculator(Integer.parseInt(amount));
        NumberOfLottoPurchased = amountCalculator.getNumberOfLottoPurchased();
    }
}