package lotto;

import java.util.List;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateBlank(numbers);
        validateSize(numbers);
        validateDuplicated(numbers);
        validateOutOfRangeOneToFortyFive(numbers);
        this.numbers = numbers;
    }


    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicated(List<Integer> numbers) {
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return numbers.size() != duplicatedSize(numbers);
    }

    private Long duplicatedSize(List<Integer> numbers) {
        return numbers.stream().distinct().count();
    }

    private void validateBlank(List<Integer> numbers) {
        if (numbers == null) {
            throw new NullPointerException();
        }
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateOutOfRangeOneToFortyFive(List<Integer> numbers) {
        for (int number : numbers) {
            checkOutOfRangeRangeOneToFortyFive(number);
        }
    }

    private void checkOutOfRangeRangeOneToFortyFive(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException();
        }
    }


}
