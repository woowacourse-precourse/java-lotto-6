package lotto.domain;

import static lotto.domain.LottoPrize.FIRST_PLACE;
import static lotto.domain.LottoPrize.SECOND_PLACE;
import static lotto.domain.LottoPrize.THIRD_PLACE;
import static lotto.domain.LottoPrize.FORTH_PLACE;
import static lotto.domain.LottoPrize.FIFTH_PLACE;
import static lotto.domain.LottoPrize.NO_PLACE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_LENGTH = 6;
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateNumberRange(numbers);
        validateDuplicateNumber(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public LottoPrize checkPrize(Lotto winningLotto, int bonusNumber) {
        int matchCount = getMatchCount(winningLotto);

        if (matchCount == FIRST_PLACE.getMatchCount()) {
            return FIRST_PLACE;
        } else if (matchCount == SECOND_PLACE.getMatchCount() && numbers.contains(bonusNumber)) {
            return SECOND_PLACE;
        } else if (matchCount == THIRD_PLACE.getMatchCount()) {
            return THIRD_PLACE;
        } else if (matchCount == FORTH_PLACE.getMatchCount()) {
            return FORTH_PLACE;
        } else if (matchCount == FIFTH_PLACE.getMatchCount()) {
            return FIFTH_PLACE;
        }
        return NO_PLACE;
    }

    private int getMatchCount(Lotto winningLotto) {
        int matchCount = 0;
        for (Integer number : numbers) {
            if (winningLotto.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
