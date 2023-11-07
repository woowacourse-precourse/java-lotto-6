package lotto.domain;

import static lotto.constants.ErrorMessage.ERROR_LOTTO_NUMBER_DUPLICATE;
import static lotto.constants.ErrorMessage.ERROR_LOTTO_NUMBER_RANGE_OVER;
import static lotto.constants.ErrorMessage.ERROR_LOTTO_NUMBER_SIZE;
import static lotto.constants.LottoConfiguration.LOTTO_SIZE;
import static lotto.constants.LottoConfiguration.MAX_RANGE;
import static lotto.constants.LottoConfiguration.MIN_RANGE;

import java.util.Collections;
import java.util.List;
import lotto.exception.LottoException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        NumberSizeCheck(numbers);
        DuplicateNumberCheck(numbers);
        NumberRangeCheck(numbers);
    }

    private void NumberSizeCheck(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE.getConfig()) {
            throw LottoException.of(ERROR_LOTTO_NUMBER_SIZE);
        }
    }

    private void DuplicateNumberCheck(List<Integer> numbers) {
        long count = numbers
                .stream()
                .distinct()
                .count();

        if (numbers.size() != count) {
            throw LottoException.of(ERROR_LOTTO_NUMBER_DUPLICATE);
        }
    }

    private void NumberRangeCheck(List<Integer> numbers) {
        boolean overRangeResult = numbers
                .stream()
                .anyMatch(num -> num < MIN_RANGE.getConfig() || num > MAX_RANGE.getConfig());

        if (overRangeResult) {
            throw LottoException.of(ERROR_LOTTO_NUMBER_RANGE_OVER);
        }
    }

    public boolean isContainsNumber(int number) {
        return numbers.contains(number);
    }

    public long lottoNumberComparison(Lotto otherLotto) {
        List<Integer> otherNumbers = otherLotto.getNumbers();
        return numbers
                .stream()
                .filter(otherNumbers::contains)
                .count();
    }

    private List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
