package lotto.controller;

import java.util.List;
import lotto.model.Constants;

public class Validation {

    public static void validatePrizeNumbers(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("서로 다른 로또 번호가 6개가 아님");
        }

        for (int num : numbers) {
            validateNumberRange(num);
        }
    }

    public static void validateNumberRange(int num) {
        if (num < Constants.LOTTO_RANGE_START || Constants.LOTTO_RANGE_END < num) {
            throw new IllegalArgumentException("로또 번호의 범위가 유효하지 않음");
        }
    }
}
