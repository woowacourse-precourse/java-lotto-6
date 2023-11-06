package lotto.model;

import static lotto.model.SystemConstant.MAX_LOTTO_NUMBER;
import static lotto.model.SystemConstant.MIN_LOTTO_NUMBER;
import static lotto.model.SystemConstant.NUM_OF_NUMBERS;
import static lotto.view.ErrorMessage.DUPLICATED_NUMBER;
import static lotto.view.ErrorMessage.NOT_EQUAL_NUM_OF_NUMBERS;
import static lotto.view.ErrorMessage.OUT_OF_RANGE_LOTTO_NUMBERS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumOfNumbers(numbers);
        validateDuplicatedNumber(numbers);
        validateRangeOfNumbers(numbers);
    }

    private void validateNumOfNumbers(List<Integer> numbers) {
        if (numbers.size() != NUM_OF_NUMBERS) {
            throw new IllegalArgumentException(NOT_EQUAL_NUM_OF_NUMBERS.getMessage());
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> check = new HashSet<>();
        for (int number : numbers) {
            if (check.contains(number)) {
                throw new IllegalArgumentException(DUPLICATED_NUMBER.getMessage());
            }
            check.add(number);
        }
    }

    private void validateRangeOfNumbers(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(OUT_OF_RANGE_LOTTO_NUMBERS.getMessage());
            }
        }
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        List<Integer> numbers = new ArrayList<>(this.numbers);
        return numbers;
    }

    public int compareLotto(Lotto firstPrizeLotto) {
        Set<Integer> check = new HashSet<>(firstPrizeLotto.getNumbers());
        int match = 0;
        for (Integer number : this.numbers) {
            if (check.contains(number)) {
                match += 1;
            }
        }
        return match;
    }

    public boolean compareBonus(int bonusNumber) {
        Set<Integer> check = new HashSet<>(this.numbers);
        return check.contains(bonusNumber);
    }
}
