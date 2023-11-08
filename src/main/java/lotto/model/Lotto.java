package lotto.model;

import lotto.constant.ErrorConstants;
import lotto.constant.GameConstants;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sortNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
    }

    private void sortNumbers(List<Integer> numbers){
        Collections.sort(numbers);
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != GameConstants.LOTTO_COUNT) {
            throw new IllegalArgumentException(ErrorConstants.OVER_LOTTO_SIZE);
        }
    }
}
