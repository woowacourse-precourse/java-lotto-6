package lotto.domain;

import static common.ErrorCode.NOT_NUMBER_STRING;
import static lotto.view.InputView.inputBonusNumber;
import static lotto.view.InputView.inputLottoPurchaseAmount;
import static lotto.view.InputView.inputWinningNumbers;

import common.exception.InvalidArgumentException;
import java.util.List;

public class Game {

    private final LottoPurchaseAmount amount;
    private final WinningNumbers winningNumbers;

    public Game() {
        this.amount = createAmount();
        this.winningNumbers = createWinningNumbers();
        addBonusNumber();
    }

    private void addBonusNumber() {
        try {
            winningNumbers.addBonus(createBonusNumber());
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    private WinningNumber createBonusNumber() {
        try {
            return createBonusNumberFromUser();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createBonusNumber();
        }
    }

    private WinningNumber createBonusNumberFromUser() {
        String input = inputBonusNumber();
        int bonusNumber = parseInt(input);
        return new WinningNumber(bonusNumber);
    }

    private WinningNumbers createWinningNumbers() {
        try {
            return createWinningNumbersFromUser();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createWinningNumbers();
        }
    }

    private WinningNumbers createWinningNumbersFromUser() {
        List<String> numbers = inputWinningNumbers();
        List<Integer> winningNumbers = numbers.stream()
                .map(this::parseInt)
                .toList();
        return new WinningNumbers(winningNumbers);
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
