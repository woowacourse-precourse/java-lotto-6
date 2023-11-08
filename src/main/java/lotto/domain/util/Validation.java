package lotto.domain.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int NUMBER_PER_LOTTO = 6;

    private Validation() {
    }

    public static void validateLottoNumbers(List<Integer> numbers) {
        if (numbers == null || numbers.size() != NUMBER_PER_LOTTO) {
            throw new IllegalArgumentException("로또 숫자는 6개 선택해야 합니다.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != NUMBER_PER_LOTTO) {
            throw new IllegalArgumentException("로또 숫자는 중복될 수 없습니다.");
        }

        if (numbers.stream()
                .anyMatch(num -> num < MIN_LOTTO_NUMBER || num > MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException("로또 숫자는 1~45까지의 정수만 선택해야 합니다.");
        }
    }
}
