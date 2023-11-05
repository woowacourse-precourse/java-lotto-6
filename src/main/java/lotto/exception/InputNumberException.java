package lotto.exception;

import lotto.util.NumberConstant;

import java.util.List;

import static lotto.exception.ErrorMessage.*;
import static lotto.util.NumberConstant.*;

public class InputNumberException {
    private InputNumberException() {
    }

    public static void inputValidate(List<String> numbers) {
        notNumberValidate(numbers);
        numberRangeValidate(numbers);
    }

    private static void notNumberValidate(List<String> numbers) {
        numbers.forEach((String number) -> {
                    try {
                        Integer.parseInt(number);
                    } catch (NumberFormatException exception) {
                        throw new IllegalArgumentException(ERROR.getMessage() + NUMBER_RANGE.getMessage());
                    }
                });
    }

    private static void numberRangeValidate(List<String> numbers) {
        long count = numbers.stream()
                .map(Integer::valueOf)
                .filter((Integer num) -> LOTTO_MIN <= num && num <= LOTTO_MAX)
                .count();

        if (count != numbers.size()) {
            throw new IllegalArgumentException(ERROR.getMessage() + NUMBER_RANGE.getMessage());
        }
    }
}
