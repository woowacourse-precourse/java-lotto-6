package lotto.domain;

import lotto.exception.DuplicateLottoNumberException;
import lotto.exception.InvalidLottoSizeException;
import lotto.exception.InvalidRangeException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortLottoNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateRange(numbers);
        validateDuplicate(numbers);
        validateSize(numbers);
    }

    private void validateRange(List<Integer> numbers) {
        numbers.forEach(this::validateRange);
    }

    private void validateRange(Integer number) {
        if (!(MIN_RANGE <= number && number <= MAX_RANGE)) {
            throw new InvalidRangeException();
        }
    }
    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new InvalidLottoSizeException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != LOTTO_SIZE) {
            throw new DuplicateLottoNumberException();
        }
    }

    private List<Integer> sortLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }

    public int getMatchLottoNumber(LottoAdmin lottoAdmin) {
        return (int) numbers.stream()
                .filter(lottoAdmin::isContain)
                .count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
