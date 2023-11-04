package lotto.exception;

import java.util.List;

import static lotto.exception.ErrorMessage.*;

public class InputNumberException {
    private static final Integer MIN_NUM = 1;
    private static final Integer MAX_NUM = 45;

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
                .filter((Integer num) -> MIN_NUM <= num && num <= MAX_NUM)
                .count();

        if (count != numbers.size()) {
            throw new IllegalArgumentException(ERROR.getMessage() + NUMBER_RANGE.getMessage());
        }
    }
}
