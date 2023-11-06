package lotto;

import java.util.HashSet;
import java.util.List;

import static lotto.LottoDetailConstant.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicateLottoNumber(numbers);
        validateRangeLottoNumberLoop(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_STORE_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicateLottoNumber(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size())
            throw new IllegalArgumentException();
    }

    private void validateRangeLottoNumberLoop(List<Integer> numbers) {
        for (int number : numbers) {
            validateRangeLottoNumber(number);
        }
    }

    private void validateRangeLottoNumber(int number) {
        if (!(number >= LOTTO_START_NUMBER && number <= LOTTO_END_NUMBER))
            throw new IllegalArgumentException();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
