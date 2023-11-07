package lotto.util;

import java.util.List;

public class TypeValidator {

    public static void validatePositiveInteger(Integer number) {
        if (number < 1) {
            throw new IllegalStateException();
        }
    }

    public static void validatePositiveIntegerList(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1) {
                throw new IllegalStateException();
            }
        }
    }
}
