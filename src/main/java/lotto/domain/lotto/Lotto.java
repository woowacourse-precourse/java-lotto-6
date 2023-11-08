package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.ExceptionMessage;
import lotto.util.LottoConstants;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
        validateNumberRange(numbers);
        this.numbers = sort(numbers);
        ;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_LOTTO_NUMBER_COUNT_MESSAGE.getErrorMessage());
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATION_NUMBER_MESSAGE.getErrorMessage());
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> !LottoConstants.isNumberInRange(number))
                .findAny()
                .ifPresent(number -> {
                    throw new IllegalArgumentException(
                            ExceptionMessage.OVER_LOTTO_NUMBER_RANGE_MESSAGE.getErrorMessage());
                });
    }

    private boolean hasDuplicate(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() < numbers.size();
    }

    protected List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private List<Integer> sort(List<Integer> numbers) {
        List sortNumbers = new ArrayList(numbers);
        Collections.sort(sortNumbers);
        return sortNumbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
