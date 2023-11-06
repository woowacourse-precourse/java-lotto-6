package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    private List<Integer> winningNumbers;
    private int purchaseAmount;

    public void setPurchaseAmount(String input) {
        int purchaseAmount = toInteger(input);
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private int toInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % Lotto.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }

    public void setWinningNumbers(String input) {
        List<String> inputs = splitInputWinningNumbers(input);
        List<Integer> winningNumbers = toIntegerWinningNumbers(inputs);
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private List<String> splitInputWinningNumbers(String input) {
        String[] inputs = input.split(",");
        return Arrays.asList(inputs);
    }

    private List<Integer> toIntegerWinningNumbers(List<String> inputs) {
        List<Integer> winningNumbers = new ArrayList<>();

        for (String input : inputs) {
            winningNumbers.add(toInteger(input));
        }

        return winningNumbers;
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        validateWinningNumbersSize(winningNumbers);
        validateWinningNumbersValue(winningNumbers);
        validateWinningNumbersDuplicated(winningNumbers);
    }

    private void validateWinningNumbersSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != Lotto.NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateWinningNumbersValue(List<Integer> winningNumbers) {
        for (Integer winningNumber : winningNumbers) {
            if (winningNumber < Lotto.MINIMUM_NUMBER || winningNumber > Lotto.MINIMUM_NUMBER) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateWinningNumbersDuplicated(List<Integer> winningNumbers) {
        Set<Integer> tmpWinningNumbers = new HashSet<>(winningNumbers);

        if (tmpWinningNumbers.size() != Lotto.NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
