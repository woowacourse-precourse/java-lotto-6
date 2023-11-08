package lotto.model;

import lotto.constant.ErrorConstants;
import lotto.constant.GameConstants;

import java.util.*;


public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }

    public int matchLottoNumbers(Lotto lotto) {
        int matchCount = 0;

        for (int number : lotto.numbers) {
            if (containsNumber(number)) {
                matchCount += 1;
            }
        }

        return matchCount;
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateLottoRange(numbers);
        validateLottoDuplication(numbers);
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

    private void validateLottoDuplication(List<Integer> numbers) {
        Set<Integer> checkNumbers = new HashSet<>(numbers);
        if (checkNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorConstants.DUPLICATE_LOTTO_NUMBER);
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
