package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ExceptionMessage;

public class Lotto {
    private final static int SIZE_LOTTO_NUMBER = 6;
    private final static int MIN_LOTTO_NUMBER = 1;
    private final static int MAX_LOTTO_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplication(numbers);

        this.numbers = numbers;
    }

    public int getMatchingNumberCount(Lotto targetLotto) {
        return this.numbers.stream()
                .filter(targetLotto.numbers::contains)
                .toList()
                .size();
    }

    public boolean isContainBonusNumber(int bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != SIZE_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_SIZE_LOTTO_NUMBER.getDesc());
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_RANGE_LOTTO_NUMBER.getDesc());
            }
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (Integer number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(ExceptionMessage.DUPLICATION_LOTTO_NUMBER.getDesc());
            }
        }
    }

}
