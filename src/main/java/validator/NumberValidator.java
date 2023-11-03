package validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberValidator {
    private NumberValidator() {
    }

    public static void sizeValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static void duplicateValidate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>();

        for (Integer number : numbers) {
            if (!numberSet.add(number)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void matchRangeValidate(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException();
            }
        }
    }
}
