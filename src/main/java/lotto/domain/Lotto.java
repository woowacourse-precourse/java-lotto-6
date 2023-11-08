package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.view.ErrorMessage.INVALID_SIZE_ERROR;
import static lotto.view.ErrorMessage.INVALID_RANGE_ERROR;
import static lotto.view.ErrorMessage.DUPLICATE_NUMBER_ERROR;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers = sortLotto(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_SIZE_ERROR);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!(MIN_RANGE <= number && MAX_RANGE >= number)) {
                throw new IllegalArgumentException(INVALID_RANGE_ERROR);
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR);
        }
    }

    private List<Integer> sortLotto(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }

    public int getMatchLottoNumber(LottoWin lottoWin) {
        return (int) numbers.stream()
                .filter(lottoWin::isContain)
                .count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
