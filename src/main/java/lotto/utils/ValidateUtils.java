package lotto.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidateUtils {

    public void validateSize(List<Integer> numbers, int size) {
        if (numbers.size() != size) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public void validateDuplicated(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        boolean isUnique = numbers.stream().allMatch(n -> uniqueNumbers.add(n));

        if (!isUnique) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public static void validateNumeric(String inputString) {
        if (!inputString.chars()
                .allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public void validateMinimum(int price, int minPrice) {
        if (price < minPrice) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public void validateRange(List<Integer> numbers, int lowerBound, int upperBound) {
        boolean isInRange = numbers.stream()
                .allMatch(n -> n >= lowerBound && n <= upperBound);

        if (!isInRange) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }
}
