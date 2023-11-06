package lotto.domain;

import static common.ErrorCode.NOT_NUMBER_STRING;
import static lotto.view.InputView.inputLottoPurchaseAmount;

import common.exception.InvalidArgumentException;

public class Game {

    private final LottoPurchaseAmount amount;

    public Game() {
        this.amount = createAmount();
    }

    private LottoPurchaseAmount createAmount() {
        try {
            return createAmountFromUser();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createAmount();
        }
    }

    private LottoPurchaseAmount createAmountFromUser() {
        String input = inputLottoPurchaseAmount();
        int amount = parseInt(input);
        return new LottoPurchaseAmount(amount);
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidArgumentException(NOT_NUMBER_STRING);
        }
    }
}
