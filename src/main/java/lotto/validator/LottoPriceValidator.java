package lotto.validator;

import java.util.List;

public class LottoPriceValidator {
    private LottoPriceValidator() {
    }

    public static void validate(final int price) {

    }

    private static void validatePrice(List<Integer> numbers) {
        if (numbers.size() != 6)
            throw new IllegalArgumentException("");
    }
}
