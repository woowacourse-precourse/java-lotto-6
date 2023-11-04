package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(String winningNumbersInput, int bonusNumber) {
        List<Integer> numbers = parseWinningNumbers(winningNumbersInput);
        validateBonusNumber(bonusNumber, numbers);
        this.winningNumbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private List<Integer> parseWinningNumbers(String commaSeparatedNumbers) {
        String[] numberStrings = commaSeparatedNumbers.split(",");
        if (numberStrings.length != 6) {
            throw new IllegalArgumentException();
        }

        Set<Integer> winningNumbersSet = new TreeSet<>();
        for (String numberString : numberStrings) {
            int number = Integer.parseInt(numberString.trim());
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException();
            }
            if (!winningNumbersSet.add(number)) {
                throw new IllegalArgumentException();
            }
        }

        return new ArrayList<>(winningNumbersSet);
    }



    private void validateBonusNumber(int bonusNumber, List<Integer> numbers) {
        if (bonusNumber < 1 || bonusNumber > 45 || numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
