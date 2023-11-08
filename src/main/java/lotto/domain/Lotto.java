package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

import static lotto.constant.DefinedNumber.LOTTO_LENGTH;
import static lotto.constant.ErrorMessage.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sortNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumberRange(numbers);
        validateDuplicateNumber(numbers);
        validateLottoNumbersSize(numbers);
    }

    private void validateLottoNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if(number <= 0 || number >= 46){
                throw new IllegalArgumentException(LOTTO_NUMBERS_RANGE_WARNING);
            }
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {

    }

    private void validateLottoNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_LENGTH_WARNING);
        }
    }

    private void sortNumbers(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if(set.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBERS_WARNING);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (Integer number : numbers) {
            joiner.add(number.toString());
        }
        return joiner.toString();
    }
}
