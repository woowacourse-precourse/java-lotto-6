package lotto;

import ui.Input;

import java.util.List;

public class Game {
    private final Input input = new Input();
    private int price;
    private int bonusNumber;
    private List<Integer> winningNumbers;
    private Error errorState = Error.NO_PROBLEM;



    private void setPrice() {
        while (!errorState.equals(Error.NO_PROBLEM)) {
            try {
                price = input.getPrice();
                validatePrice();
            } catch (IllegalArgumentException e) {
                errorState.printERROR(errorState);
            }
        }
    }

    private void setWinningNumbers() {
        while (!errorState.equals(Error.NO_PROBLEM)) {
            try {
                winningNumbers = input.getWinningNumbers();
                validateWinningNumbers();
            } catch (IllegalArgumentException e) {
                errorState.printERROR(errorState);
            }
        }
    }

    private void setBonusNumber() {
        while (!errorState.equals(Error.NO_PROBLEM)) {
            try {
                bonusNumber = input.getBonusNumber();
                validateBonusNumber();
            } catch (IllegalArgumentException e) {
                errorState.printERROR(errorState);
            }
        }
    }

    private void validatePrice() {
        if (price % 1000 != 0) {
            errorState = Error.PRICE_ERROR;
            throw new IllegalArgumentException();
        }
        errorState = Error.NO_PROBLEM;
    }

    private void validateWinningNumbers() {
        if (winningNumbers.size() != 6) {
            errorState = Error.WINNING_NUMBER_OUT_OF_COUNT_ERROR;
            throw new IllegalArgumentException();
        } else if (winningNumbers.size() > winningNumbers.stream().distinct().count()) {
            errorState = Error.WINNING_NUMBER_DUPLICATE_ERROR;
            throw new IllegalArgumentException();
        } else if (winningNumbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            errorState = Error.WINNING_NUMBER_OUT_OF_RANGE_ERROR;
            throw new IllegalArgumentException();
        }
        errorState = Error.NO_PROBLEM;
    }

    private void validateBonusNumber() {
        if (winningNumbers.contains(bonusNumber)) {
            errorState = Error.BONUS_NUMBER_DUPLICATE_ERROR;
            throw new IllegalArgumentException();
        } else if (bonusNumber < 1 || bonusNumber > 45) {
            errorState = Error.BONUS_NUMBER_OUT_OF_RANGE_ERROR;
            throw new IllegalArgumentException();
        }
        errorState = Error.NO_PROBLEM;
    }
}
