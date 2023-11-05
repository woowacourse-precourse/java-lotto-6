package lotto.domain;

import static common.ErrorCode.NOT_NUMBER_STRING;
import static lotto.view.InputView.inputLottoAmount;

import common.exception.InvalidArgumentException;

public class Game {

    public static void main(String[] args) {
        new Game();
    }

    private final Amount amount;

    public Game() {
        this.amount = createAmount();
    }

    private Amount createAmount() {
        try {
            return createAmountFromUser();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createAmount();
        }
    }

    private Amount createAmountFromUser() {
        String input = inputLottoAmount();
        int amount = parseInt(input);
        return new Amount(amount);
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidArgumentException(NOT_NUMBER_STRING);
        }
    }
}
