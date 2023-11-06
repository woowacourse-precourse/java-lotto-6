package lotto.domain;

import static lotto.enums.LottoPrize.FIRST_PLACE;
import static lotto.enums.LottoPrize.SECOND_PLACE;
import static lotto.enums.LottoPrize.THIRD_PLACE;
import static lotto.enums.LottoPrize.FORTH_PLACE;
import static lotto.enums.LottoPrize.FIFTH_PLACE;
import static lotto.enums.LottoPrize.NO_PLACE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.enums.LottoPrize;

public class Lotto {
    private static final int LOTTO_LENGTH = 6;
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private static final String LOTTO_LENGTH_ERROR_MESSAGE = "로또 숫자는 6개 입니다.";
    private static final String NUMBER_RANGE_ERROR_MESSAGE = "로또의 수는 1에서 45사이의 숫자 입니다.";
    private static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "로또에 중복된 수가 있습니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers = new ArrayList<>(numbers);
        numbers.sort(null);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateNumberRange(numbers);
        validateDuplicateNumber(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(LOTTO_LENGTH_ERROR_MESSAGE);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER) {
                throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
            }
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
        }
    }

    public LottoPrize checkPrize(WinningLotto winningLotto) {
        int matchCount = getMatchCount(winningLotto);
        int bonusNumber = winningLotto.getBonusNumber();

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

    private int getMatchCount(WinningLotto winningLotto) {
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
