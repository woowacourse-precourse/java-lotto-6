package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;
    private static final int MINIMUM_RANGE = 1;
    private static final int MAXIMUM_RANGE = 45;
    private static final int NUMBER_PICK_COUNT = 6;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        validateRange(numbers);
        this.numbers = sortedNumbers(numbers);
    }

    private List<Integer> sortedNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_PICK_COUNT) {
            throw new IllegalArgumentException("[Error] 로또 번호가 6개가 아닙니다.");
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("[Error] 로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MINIMUM_RANGE || number > MAXIMUM_RANGE) {
                throw new IllegalArgumentException("[Error] 로또 번호는 1부터 45까지입니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
