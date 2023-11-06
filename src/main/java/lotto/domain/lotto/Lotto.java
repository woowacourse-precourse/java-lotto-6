package lotto.domain.lotto;

import static lotto.domain.lotto.LottoErrorMessage.DUPLICATION_ERROR;
import static lotto.domain.lotto.LottoErrorMessage.INVALID_RANGE_ERROR;
import static lotto.domain.lotto.LottoErrorMessage.SIZE_ERROR;
import static lotto.domain.lotto.LottoNumberConfig.MAXIMUM_RANGE;
import static lotto.domain.lotto.LottoNumberConfig.MINIMUM_RANGE;
import static lotto.domain.lotto.LottoNumberConfig.NUMBER_COUNT;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if(validateSize(numbers)) {
            throw new IllegalArgumentException(SIZE_ERROR.getMessage());
        }
        if(validateDuplication(numbers)) {
            throw new IllegalArgumentException(DUPLICATION_ERROR.getMessage());
        }
        if(validateRange(numbers)) {
            throw new IllegalArgumentException(INVALID_RANGE_ERROR.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    private boolean validateSize(List<Integer> numbers) {
        return  (numbers.size() != NUMBER_COUNT.getValue());
    }

    private boolean validateDuplication(List<Integer> numbers) {
        return (numbers.stream()
                .distinct()
                .count() != NUMBER_COUNT.getValue());
    }

    private boolean validateRange(List<Integer> numbers) {
        return !numbers.stream()
                .filter(number -> number < MINIMUM_RANGE.getValue() ||
                        number > MAXIMUM_RANGE.getValue())
                .toList()
                .isEmpty();
    }


}
