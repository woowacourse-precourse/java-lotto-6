package model;

import consts.LottoConsts;
import exception.DuplicateLottoNumberException;
import exception.WrongLottoSizeException;
import exception.WrongRangeLottoNumberException;
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
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    // TODO: 추가 기능 구현
    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoConsts.LOTTO_SIZE) {
            throw new WrongLottoSizeException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.forEach(this::validateRange);
    }

    private void validateRange(Integer number) {
        if (!(LottoConsts.MIN_RANGE <= number && number <= LottoConsts.MAX_RANGE)) {
            throw new WrongRangeLottoNumberException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != LottoConsts.LOTTO_SIZE) {
            throw new DuplicateLottoNumberException();
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

    public List<Integer> getNumbers() {
        return numbers;
    }

}
