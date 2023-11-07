package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.ErrorMessage;

public class PlayerNumber {
    private final int WINNING_NUMBER_SIZE = 6;
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 45;
    private final List<Integer> winningNumber;
    private final int bonusNumber;

    public PlayerNumber(List<Integer> winningNumber, int bonusNumber) {
        validateWinningNumberSize(winningNumber);
        for(int number : winningNumber) {
            validateNumber(number);
        }
        validateWinningNumberUnique(winningNumber);
        this.winningNumber = winningNumber;

        validateNumber(bonusNumber);
        validateBonusNumberUnique(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateWinningNumberSize(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUMBER_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_SIZE.getMessage());
        }
    }

    private void validateWinningNumberUnique(List<Integer> numbers) {
        List<Integer> distinctList = numbers.stream().distinct().toList();

        if (numbers.size() != distinctList.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    private void validateNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.getMessage());
        }
    }

    private void validateBonusNumberUnique(int number) {
        if (winningNumber.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

}
