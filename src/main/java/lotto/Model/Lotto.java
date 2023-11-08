package lotto.Model;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final int MINIMUM_LOTTO_NUMBER = 1;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSixNumbers(numbers);
        validateNoDuplicates(numbers);
        validateAllNumbersInRange(numbers);
    }

    private void validateSixNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 정확히 6개의 숫자를 입력해야 합니다.");
        }
    }

    private void validateNoDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new LinkedHashSet<>(numbers);
        if (uniqueNumbers.size() < numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }

    private void validateAllNumbersInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number > MAXIMUM_LOTTO_NUMBER || number < MINIMUM_LOTTO_NUMBER)
                throw new IllegalArgumentException("[ERROR] 숫자는 " + MINIMUM_LOTTO_NUMBER + "에서 " + MAXIMUM_LOTTO_NUMBER + " 사이어야 합니다: " + number);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
