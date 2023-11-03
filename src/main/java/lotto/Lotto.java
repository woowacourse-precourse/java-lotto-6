package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int MIN_LOTTE_NUMBER = 1;
    public static final int MAX_LOTTE_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSixNumberCount(numbers);
        validateOverlapNumber(numbers);
        this.numbers = numbers;
    }

    public int countCorrectLottoNumber(Set<Integer> prizeNumbers) {
        int correctNumberCount = 0;

        for (Integer number : numbers) {
            if (prizeNumbers.contains(number)) {
                correctNumberCount++;
            }
        }

        return correctNumberCount;
    }

    private void validateSixNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateOverlapNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (Integer number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException("중복된 번호를 입력 하였습니다.");
            }
        }
    }
}
