package utils;

import type.ErrorType;

import java.util.List;

public class Validator {
    public static void checkLottoSizeNumberInput(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorType.INVALID_NUMBER_DIGITS.getText());
        }
    }
//
//    static void checkLottoDuplicatedNumberInput(List<Integer> numbers) {
//        long count = numbers.stream()
//                .distinct()
//                .count();
//    }
}
