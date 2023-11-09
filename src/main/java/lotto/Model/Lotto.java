package lotto.Model;

import lotto.Util.Rule;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers = sorted(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != Rule.MAX_LENGTH) {
            throw new IllegalArgumentException(Rule.LOTTO_NUM_SIZE_ERROR);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> NotDuplicateNumbers = new HashSet<>(numbers);
        if(NotDuplicateNumbers.size() != Rule.MAX_LENGTH) {
            throw new IllegalArgumentException(Rule.LOTTO_NUM_DUPLICATE_ERROR);
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.forEach(this::validateRange);
    }

    private void validateRange(Integer numbers) {
        Set<Integer> NotDuplicateNumbers = new HashSet<>(numbers);
        NotDuplicateNumbers.add(numbers);
        if(!(Rule.MIN_NUMBER <= numbers && numbers <= Rule.MAX_NUMBER)) {
            throw new IllegalArgumentException(Rule.LOTTO_NUM_RANGE);
        }
    }

    public List<Integer> sorted(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }


    public boolean isContain(int number) {
        return numbers.contains(number);
    }

    public int getMatchLottoNumber(WinningLotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto::isContain)
                .count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
