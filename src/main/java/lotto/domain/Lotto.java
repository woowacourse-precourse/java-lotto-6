package lotto.domain;

import static lotto.constant.LottoConstant.LOTTO_NUMBER_COUNT;
import static lotto.constant.LottoConstant.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoConstant.MIN_LOTTO_NUMBER;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ExceptionMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplication(numbers);

        this.numbers = new ArrayList<>(numbers);
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
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
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
