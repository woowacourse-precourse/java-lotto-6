package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.controller.exception.DuplicationException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validationDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    private List<Integer> numberSort(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private void validationDuplicate(List<Integer> numbers) {
        Set<Integer> checkNumbers = new HashSet<>(numbers);
        if (checkNumbers.size() != 6) {
            throw new DuplicationException();
        }
    }

    public boolean numberContain(int number) {
        return numbers.contains(number);
    }

    public int getCountMatchNumbers(WinningLottoNumbers winningLottoNumbers) {
        return (int) numbers.stream()
                .filter(winningLottoNumbers::numberContain)
                .count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
