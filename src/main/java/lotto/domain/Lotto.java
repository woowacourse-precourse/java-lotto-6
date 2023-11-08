package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.constant.LottoConstant;
import lotto.exception.lotto.LottoDuplicateException;
import lotto.exception.lotto.LottoRangeException;
import lotto.exception.lotto.LottoSizeException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = sort(numbers);
    }

    public boolean contains(final BonusNumber bonusNumber) {
        return numbers.contains(bonusNumber.
                value());
    }

    public int countMatchingNumbers(final Lotto other) {
        return (int) numbers.stream()
                .filter(other.numbers::contains)
                .count();
    }

    private void validate(final List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private static void validateSize(final List<Integer> numbers) {
        if (numbers.size() != LottoConstant.SIZE.getValue()) {
            throw new LottoSizeException();
        }
    }

    private void validateRange(final List<Integer> numbers) {
        for (Integer number : numbers) {
            checkRange(number);
        }
    }

    private static void checkRange(final Integer number) {
        if (number < LottoConstant.MIN_NUMBER.getValue() || number > LottoConstant.MAX_NUMBER.getValue()) {
            throw new LottoRangeException();
        }
    }

    private static void validateDuplicate(final List<Integer> numbers) {
        Set<Integer> duplicateLotto = new HashSet<>();
        numbers.forEach(number -> checkDuplicate(number, duplicateLotto));
    }

    private static void checkDuplicate(final Integer number, final Set<Integer> duplicateLotto) {
        if (!duplicateLotto.add(number)) {
            throw new LottoDuplicateException();
        }
    }

    private static List<Integer> sort(final List<Integer> list) {
        return list.stream()
                .sorted()
                .toList();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}