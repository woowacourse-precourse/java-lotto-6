package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.LottoConstant;
import lotto.constant.NumberRange;

public class WinningNumbers {
    private List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        lengthValidate(numbers);
        duplicationValidate(numbers);
        rangeValidate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void lengthValidate(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void duplicationValidate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            if (set.contains(number)) {
                throw new IllegalArgumentException();
            }
            set.add(number);
        }
    }

    private void rangeValidate(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < NumberRange.MIN.getNumber() || number > NumberRange.MAX.getNumber()) {
                throw new IllegalArgumentException();
            }
        }
    }
}
