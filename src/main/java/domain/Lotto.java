package domain;

import exception.InvalidLottoNumberRangeException;
import exception.InvalidLottoSizeException;
import exception.NumberDuplicateException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int MAX_RANGE = 45;
    private static final int MIN_RANGE = 1;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers = sorted(numbers);
        this.numbers = numbers;
    }

    private List<Integer> sorted(List<Integer> numbers) {
        List<Integer> sortedList = new ArrayList<>(numbers);
        Collections.sort(sortedList);
        return sortedList;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateNumberRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new InvalidLottoSizeException();
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!(MIN_RANGE <= number && number <= MAX_RANGE)) {
                throw new InvalidLottoNumberRangeException();
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != LOTTO_SIZE) {
            throw new NumberDuplicateException();
        }
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getMatchedNumbers(WinningLotto winningLotto) {
        int result = 0;

        for (int lottoNumber : numbers) {
            if (winningLotto.hasNumber(lottoNumber)) {
                result++;
            }
        }

        return result;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
