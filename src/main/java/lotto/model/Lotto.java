package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        for (Integer number : numbers) {
            int frequency = Collections.frequency(numbers, number);
            if (frequency >= Validator.NUMBERS_MIN_DUPLICATE_COUNT) {
                throw new IllegalArgumentException();
            }
        }

    }

    public static List<Integer> generateLotteryNumbers() {
        List<Integer> lotteryNumbers = new ArrayList<>();
        List<Integer> numbersInRange = Randoms.
                pickUniqueNumbersInRange(1, 45, 6);
        lotteryNumbers.addAll(numbersInRange);
        return lotteryNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
