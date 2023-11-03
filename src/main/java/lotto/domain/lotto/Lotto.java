package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import lotto.exception.domain.lotto.LottoDuplicateNumException;
import lotto.exception.domain.lotto.LottoNumRangeException;
import lotto.exception.domain.lotto.LottoSizeException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers = sortNumbers(numbers);
        this.numbers = numbers;
    }

    public Collection<Integer> getLotto() {
        return Collections.unmodifiableCollection(numbers);
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    private void validate(List<Integer> numbers) {
        validateSizeOfNumbers(numbers);
        validateDuplicateNumber(numbers);
        validateRangeOfNumber(numbers);
    }

    private void validateSizeOfNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoSizeException();
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        long uniqueLottoNumSize = numbers.stream()
                .distinct()
                .count();

        if (uniqueLottoNumSize != 6) {
            throw new LottoDuplicateNumException();
        }
    }

    private void validateRangeOfNumber(List<Integer> numbers) {
        if (hasInvalidRangeNumber(numbers)) {
            throw new LottoNumRangeException();
        }
    }

    private boolean hasInvalidRangeNumber(List<Integer> numbers) {
        return !numbers.stream()
                .allMatch(num -> isValidRange(num));
    }

    private static boolean isValidRange(Integer num) {
        return num >= 1 && num <= 45;
    }
}
