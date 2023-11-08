package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constants.Constant.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateOverlap(numbers);
        validateRange(numbers);

        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    public int countMatch(Lotto winningLotto) {
        return (int) numbers.stream().
                filter(winningLotto::containNumber).
                count();
    }

    public boolean containNumber(int number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NUMBER_SIZE_ERROR_MESSAGE);
        }
    }

    private void validateOverlap(List<Integer> numbers) {
        Set<Integer> checkOverlap = new HashSet<>();
        for (int i = 0; i < numbers.size(); i++) {
            checkOverlap.add(numbers.get(i));
        }
        if (checkOverlap.size() != 6) {
            throw new IllegalArgumentException(NUMBER_OVERLAP_ERROR_MESSAGE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < MIN_LOTTO_NUMBER || numbers.get(i) > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
            }
        }
    }

    public static void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
        }
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(NUMBER_OVERLAP_ERROR_MESSAGE);
        }
    }

}
