package lotto.domain;

import static lotto.constants.Condition.MAXIMUM_VALUE;
import static lotto.constants.Condition.MINIMUM_VALUE;
import static lotto.constants.ErrorMessage.DUPLICATED_LOTTO_NUMBER;
import static lotto.constants.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.utility.vo.LottoResponse;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        for(Integer number: numbers) {
            if(number.compareTo(MINIMUM_VALUE) < 0 || number.compareTo(MAXIMUM_VALUE) > 0) {
                throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE);
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> distinctSet = new HashSet<>(numbers);
        if(distinctSet.size() < numbers.size()) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER);
        }
    }

    private void sortIncreasingOrder() {
        Collections.sort(numbers);
    }

    public LottoResponse convertToResponse() {
        sortIncreasingOrder();
        return new LottoResponse(numbers);
    }
}
