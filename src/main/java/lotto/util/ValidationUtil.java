package lotto.util;

import java.util.List;
import java.util.Optional;
import lotto.enums.ConstVariable;

public class ValidationUtil {

    public static void isValidNumber(List<Integer> numbers) {
        Optional<Integer> result = numbers.stream()
                .filter(number -> number < ConstVariable.MIN_NUMBER.getValue()
                        || number > ConstVariable.MAX_NUMBER.getValue())
                .findFirst();

        if (result.isPresent()) {
            throw new IllegalArgumentException();
        }
    }

    public static void isValidCount(List<Integer> numbers) {
        if (numbers.size() != ConstVariable.LOTTO_COUNT.getValue()) {
            throw new IllegalArgumentException();
        }
    }
}
