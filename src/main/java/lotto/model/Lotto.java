package lotto.model;

import lotto.constant.ErrorConstants;
import lotto.constant.GameConstants;

import java.util.Collections;
import java.util.List;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sortNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateLottoRange(numbers);
    }

    private void sortNumbers(List<Integer> numbers){
        Collections.sort(numbers);
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != GameConstants.LOTTO_COUNT) {
            throw new IllegalArgumentException(ErrorConstants.OVER_LOTTO_SIZE);
        }
    }

    private void validateLottoRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < GameConstants.MIN_RANGE || number > GameConstants.MAX_RANGE) {
                throw new IllegalArgumentException(ErrorConstants.OVER_LOTTO_RANGE);
            }
        }
    }

}
