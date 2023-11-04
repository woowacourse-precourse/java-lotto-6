package lotto.validator;

import static lotto.constant.ErrorMessage.DIFFERENT_COUNT_MESSAGE;
import static lotto.constant.ErrorMessage.DUPLICATED_NUMBER_MESSAGE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {
    public static void numbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(DIFFERENT_COUNT_MESSAGE);
        }
    }

    public static void numbersDuplication(List<Integer> numbers) {
        Set<Integer> checkDuplication = new HashSet<>();
        numbers.forEach((number) -> {
            if (isDuplicated(checkDuplication, number)) {
                throw new IllegalArgumentException(DUPLICATED_NUMBER_MESSAGE);
            }
        });
    }

    private static boolean isDuplicated(Set<Integer> checkDuplication, int number) {
        if (checkDuplication.add(number)) {
            return false;
        }
        return true;
    }
}
