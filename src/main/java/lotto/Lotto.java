package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.InvalidSizeLottoNumberException;
import lotto.exception.DuplicateLottoNumberException;


public class Lotto {
    private static final int LOTTO_SIZE = 6;

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {

    }
    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new InvalidSizeLottoNumberException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != LOTTO_SIZE) {
            throw new DuplicateLottoNumberException();
        }
    }
}