package lotto.model;

import java.util.List;

public class Lotto {
    private static final Integer COUNT_OF_LOTTO_NUMBERS = 6;
    private static final Integer START_RANGE_OF_NUMBER = 1;
    private static final Integer END_RANGE_OF_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateCount(numbers);
        validateDuplicate(numbers);
        validateEachNumber(numbers);

        this.numbers = numbers;
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != COUNT_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException(); // 에러문 추가
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != COUNT_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException(); // 에러문 추가
        }
    }

    private void validateEachNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < START_RANGE_OF_NUMBER || END_RANGE_OF_NUMBER < number) {
                throw new IllegalArgumentException(); // 에러문 추가
            }
        }
    }

    // 로또 번호 비교 로직 추가
}
