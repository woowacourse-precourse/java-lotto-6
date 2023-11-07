package lotto.controller;

import java.util.List;
import lotto.model.Constants;

public class Validation {

    public static void validatePrizeNumbers(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }

        for (int num : numbers) {
            validateNumberRange(num);
        }
    }

    public static void validateNumberRange(int num) {
        if (num < Constants.LOTTO_RANGE_START || Constants.LOTTO_RANGE_END < num) {
            throw new IllegalArgumentException();
        }
    }
}
