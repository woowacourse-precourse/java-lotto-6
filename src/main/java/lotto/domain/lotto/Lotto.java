package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import lotto.exception.LottoExceptionMessage;

public class Lotto {
    private static final int EXPECTED_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        isDuplicate(numbers);
        this.numbers = numbers;
    }

    public String getSortedNumbers() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers.stream().toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != EXPECTED_COUNT) {
            throw new IllegalArgumentException(LottoExceptionMessage.LOTTO_NUMBERS_MUST_BE_SIX_DIGITS.getMessage());
        }
    }

    private void isDuplicate(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>(numbers);
        if (set.size() != EXPECTED_COUNT) {
            throw new IllegalArgumentException(LottoExceptionMessage.LOTTO_NUMBERS_MUST_BE_SIX_DIGITS.getMessage());
        }
    }
}
