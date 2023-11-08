package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import lotto.config.LottoConfig;
import lotto.exception.Errors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        validate(sortedNumbers);
        this.numbers = Collections.unmodifiableList(sortedNumbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConfig.MAX_BALLS) {
            throw Errors.INVALID_SIZE.getLottoException();
        }
        if (hasDuplicatedNumbers(numbers)) {
            throw Errors.INVALID_DUPLICATED.getLottoException();
        }
        if (hasNumberOutOfRange(numbers)) {
            throw Errors.INVALID_RANGE.getLottoException();
        }
        if (isNotSorted(numbers)) {
            throw Errors.INVALID_SORTING.getStatusException();
        }
    }

    private boolean hasDuplicatedNumbers(List<Integer> numbers) {
        long count = numbers.stream()
                .distinct()
                .count();
        return count != LottoConfig.MAX_BALLS;
    }

    private boolean hasNumberOutOfRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> LottoConfig.MIN_NUMBER > number || number > LottoConfig.MAX_NUMBER);
    }

    private boolean isNotSorted(List<Integer> numbers) {
        return IntStream.range(1, numbers.size())
                .anyMatch(index -> numbers.get(index) < numbers.get(index - 1));
    }

    public int countMatches(final Lotto winningLotto) {
        return Math.toIntExact(this.numbers.stream()
                .filter(winningLotto.numbers::contains)
                .count());
    }

    public boolean contains(BonusNumber bonusNumber) {
        return numbers.contains(bonusNumber.getValue());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
