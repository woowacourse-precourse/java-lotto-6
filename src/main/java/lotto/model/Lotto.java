package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateCount(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);

        this.numbers = numbers;
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != COUNT_OF_LOTTO_NUMBERS) { // 상수 enum 추가
            throw new IllegalArgumentException(); // 에러문 추가
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != COUNT_OF_LOTTO_NUMBERS) { // 상수 enum 추가
            throw new IllegalArgumentException(); // 에러문 추가
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < START_RANGE_OF_NUMBER || END_RANGE_OF_NUMBER < number) { // 상수 enum 추가
                throw new IllegalArgumentException(); // 에러문 추가
            }
        }
    }

    public Integer countMatchesNumber(Lotto targetLotto) {
        Integer count = 0;

        for (Integer number : numbers) {
            if (targetLotto.isMatch(number)) {
                ++count;
            }
        }

        return count;
    }

    public Boolean isMatch(Integer number) {
        return numbers.contains(number);
    }
}
