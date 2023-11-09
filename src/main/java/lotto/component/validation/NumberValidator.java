package lotto.component.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberValidator {

    public static void validate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] numbers size must be 6");
            throw new IllegalArgumentException("[ERROR] numbers size must be 6");
        }
        validateUnique(numbers);
        validateNumbersRange(numbers);
    }

    public static void validateUnique(List<Integer> numbers) throws IllegalArgumentException {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            System.out.println("[ERROR] numbers must be unique");
            throw new IllegalArgumentException("[ERROR] number must be unique");
        }
    }

    public static void validateUniqueWithBonus(List<Integer> numbers, Integer bonus) throws IllegalArgumentException {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        uniqueNumbers.add(bonus);
        if (uniqueNumbers.size() != numbers.size() + 1) {
            System.out.println("[ERROR] numbers must be unique with bonus");
            throw new IllegalArgumentException("[ERROR] numbers must be unique with bonus");
        }
    }

    public static void validateNumbersRange(List<Integer> numbers) throws IllegalArgumentException {
        for (Integer number : numbers) {
            validateNumberRange(number);
        }
    }

    public static void validateNumberRange(Integer number) throws IllegalArgumentException {
        if (number < 1 || number > 45) {
            System.out.println("[ERROR] number must be between 1 and 45");
            throw new IllegalArgumentException("[ERROR] number must be between 1 and 45");
        }
    }

}
