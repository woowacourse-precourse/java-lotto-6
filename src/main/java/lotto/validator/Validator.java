package lotto.validator;

import java.util.HashSet;
import java.util.List;
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

    public boolean containsDuplicatedNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() < numbers.size();
    }

    public boolean checkNumbersSize(List<Integer> numbers) {
        return numbers.size() == 6;
    }

    public boolean checkRangeValidity(List<Integer> numbers) {
        List<Integer> filteredNumbers = numbers.stream()
                .filter(number -> number < 1 || number > 45)
                .toList();
        return filteredNumbers.size() == 0;
    }
}
