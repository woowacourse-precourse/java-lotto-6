package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Validator {

    public boolean containsNonNumericCharacters(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPositiveMultiplesOfThousand(int input) {
        return input % 1000 == 0 && input >= 0;
    }

    public boolean containsDuplicatedNumbers(List<Integer> winningNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        return uniqueNumbers.size() < winningNumbers.size();
    }

    public boolean checkNumbersSize(List<Integer> winningNumbers) {
        return winningNumbers.size() == 6;
    }

    public boolean checkRangeValidity(List<Integer> winningNumbers) {
        List<Integer> filteredNumbers = winningNumbers.stream()
                .filter(number -> number < 1 || number > 45)
                .toList();
        return filteredNumbers.size() == 0;
    }
}
