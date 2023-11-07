package lotto.controller;

import lotto.service.AmountCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    private String amount;
    private int NumberOfLottoPurchased;

    public void play() {
        getAmount();
        printNumberOfLottoPurcased();
    }

    private void getAmount() {
        amount = InputView.AMOUNT.getInput();
        AmountCalculator amountCalculator = new AmountCalculator(Integer.parseInt(amount));
        NumberOfLottoPurchased = amountCalculator.getNumberOfLottoPurchased();
    }

    private void printNumberOfLottoPurcased() {
        OutputView.printNumberOfLottoPurchased(NumberOfLottoPurchased);
    }
}