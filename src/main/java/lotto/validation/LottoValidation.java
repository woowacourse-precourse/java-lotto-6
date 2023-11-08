package lotto.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidation {
    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_LAST_NUMBER = 45;
    public static final int LOTTO_NUMBER_COUNT = 6;

    public static boolean validateRange(List<Integer> numbers) {
        return numbers.stream().allMatch(number -> number >= LOTTO_START_NUMBER && number <= LOTTO_LAST_NUMBER);
    }

    public static boolean validateDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() == numbers.size();
    }

    public static boolean validateLength(List<Integer> numbers) {
        return numbers.size() == LOTTO_NUMBER_COUNT;
    }
}
