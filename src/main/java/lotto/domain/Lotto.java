package lotto.domain;

import java.util.List;
import lotto.exception.DuplicateNumbersLottoException;
import lotto.exception.InvalidNumberScopeException;
import lotto.exception.InvalidSizeOfLottoNumbersException;

public class Lotto {
    private static final Integer LOTTO_SIZE = 6;
    private static final Integer MINIMUM_LOTTO_NUMBER = 1;
    private static final Integer MAXIMUM_LOTTO_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {

        validateSize(numbers);
        validateNumberScope(numbers);
        validateDuplicatedNumber(numbers);

        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new InvalidSizeOfLottoNumbersException();
        }
    }

    private void validateNumberScope(List<Integer> numbers) {

        for (Integer number : numbers) {
            if (number < MINIMUM_LOTTO_NUMBER) {
                throw new InvalidNumberScopeException();
            }
            if (number > MAXIMUM_LOTTO_NUMBER) {
                throw new InvalidNumberScopeException();
            }
        }

    }

    private void validateDuplicatedNumber(List<Integer> numbers) {

        int count = (int) numbers.stream().distinct().count();

        if (count < LOTTO_SIZE) {
            throw new DuplicateNumbersLottoException();
        }

    }

}
