package lotto;

import lotto.domain.WinningLotto;
import lotto.exception.lotto.win.LottoNumberDuplicateException;
import lotto.exception.lotto.win.LottoNumberRangeException;
import lotto.exception.lotto.win.LottoNumberSizeException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final int Input_LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers = sorted(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateInputLottoSize(numbers);
        validateInputLottoRange(numbers);
        validateInputLottoDuplicate(numbers);
    }

    private void validateInputLottoSize(List<Integer> numbers) {
        if (numbers.size() != Input_LOTTO_SIZE) {
            throw new LottoNumberSizeException();
        }
    }

    private void validateInputLottoRange(List<Integer> numbers) {
        numbers.forEach(this::validateInputLottoRange);
    }

    private void validateInputLottoRange(Integer number) {
        if (!(MIN_RANGE <= number && number <= MAX_RANGE)) {
            throw new LottoNumberRangeException();
        }
    }

    private void validateInputLottoDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != Input_LOTTO_SIZE) {
            throw new LottoNumberDuplicateException();
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
