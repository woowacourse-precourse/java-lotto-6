package lotto.util;

import static lotto.domain.enums.LottoConstants.LOTTO_SIZE;
import static lotto.domain.enums.LottoConstants.MAX_LOTTO_NUM;
import static lotto.domain.enums.LottoConstants.MIN_LOTTO_NUM;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public static void validateNumbersRange(List<Integer> numbers) {
        numbers.stream()
                .forEach(number -> validateNumberRange(number));
    }

    public static void validateNumberRange(int number) {
        if (number < MIN_LOTTO_NUM || number > MAX_LOTTO_NUM) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateDuplicateLottoNumbers(List<Integer> numbers) {
        Set<Integer> unDuplicatedNumbers = new HashSet<>(numbers);
        if (unDuplicatedNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public static int validateNumeric(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateDivisibleBy(int money, int divisor) {
        if (money % divisor != 0) {
            throw new IllegalArgumentException();
        }
    }
}
