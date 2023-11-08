package lotto.domain;

import static lotto.constants.ErrorMessage.DUPLICATED_LOTTO_NUMBER;
import static lotto.constants.ErrorMessage.INVALID_LOTTO_SIZE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.utility.validation.LottoNumberChecker;
import lotto.vo.response.LottoResponse;

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
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE);
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

    private List<Integer> sortIncreasingOrder() {
        List<Integer> mutableNumbers = new ArrayList<>(numbers);
        Collections.sort(mutableNumbers);
        return mutableNumbers;
    }

    public LottoResponse convertToResponse() {
        List<Integer> sortedNumbers = sortIncreasingOrder();
        return new LottoResponse(sortedNumbers);
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
