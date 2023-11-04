package lotto.util.validators;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.exception.DuplicationNumberException;
import lotto.util.exception.LengthGreaterThanSixException;

public class LottoValidator {
    public static void validateLotto(List<Integer> numbers) {
        lengthGreaterThanSix(numbers);
        NumberDuplicates(numbers);
    }

    private static void lengthGreaterThanSix(List<Integer> numbers) {
        if (numbers.size() > 6) {
            throw LengthGreaterThanSixException.LENGTH_GREATER_THAN_SIX.getException();
        }
    }

    private static void NumberDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() != uniqueNumbers.size()) {
            throw DuplicationNumberException.DUPLICATE_NUMBERS.getException();
        }
    }
}
