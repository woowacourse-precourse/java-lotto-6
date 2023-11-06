package lotto.domain;

import static lotto.constants.Condition.MAXIMUM_VALUE;
import static lotto.constants.Condition.MINIMUM_VALUE;
import static lotto.constants.ErrorMessage.DUPLICATED_LOTTO_NUMBER;
import static lotto.constants.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.utility.validation.LottoNumberChecker;
import lotto.utility.vo.LottoResponse;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateNumber(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumber(List<Integer> numbers) {
        numbers.stream()
            .forEach(number -> LottoNumberChecker.validate(number));
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

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    public int countMatching(Lotto other) {
        return (int) numbers.stream()
            .filter(num -> other.contains(num))
            .count();
    }
}
