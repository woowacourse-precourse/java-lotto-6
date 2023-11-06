package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.execption.DuplicateLottoNumberException;
import lotto.execption.LottoNumberRangeException;
import lotto.execption.LottoNumberSizeException;


public class Lotto {
    private static final Integer LOTTO_SIZE = 6;
    private static final Integer NUMBER_START_RANGE = 1;
    private static final Integer NUMBER_END_RANGE = 45;

    private final List<Integer> numbers;


    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        numbers = sort(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new LottoNumberSizeException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != LOTTO_SIZE) {
            throw new DuplicateLottoNumberException();
        }
    }

    public void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < NUMBER_START_RANGE || number > NUMBER_END_RANGE) {
                throw new LottoNumberRangeException();
            }
        }
    }

    private List<Integer> sort(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    @Override

    public String toString() {
        return numbers.toString();
    }
}
