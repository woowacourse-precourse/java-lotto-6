package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int CORRECT_LOTTO_SIZE = 6;
    private static final String LOTTO_NUMBER_WRONG_RANGE_EXCEPTION_MESSAGE = "숫자가 1에서 45 사이의 범위를 벗어납니다.";
    private static final String LOTTO_NUMBER_DUPLICATE_EXCEPTION_MESSAGE = "중복된 숫자가 존재합니다";
    private static final String LOTTO_NUMBER_SIZE_NOT_SIX_EXCEPTION_MESSAGE = "로또 개수는 6개여야 합니다";

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumberCount(numbers);
        validateUniqueNumber(numbers);
        validateCorrectRange(numbers);
    }

    private void validateCorrectRange(List<Integer> numbers) {
        boolean isValid = numbers.stream()
                .allMatch(number -> (number >= LOTTO_MIN_NUMBER)
                        && (number <= LOTTO_MAX_NUMBER));

        if (!isValid) {
            throw new IllegalArgumentException(LOTTO_NUMBER_WRONG_RANGE_EXCEPTION_MESSAGE);
        }
    }

    private void validateUniqueNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (Integer number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_EXCEPTION_MESSAGE);
            }
        }
    }

    private void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != CORRECT_LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBER_SIZE_NOT_SIX_EXCEPTION_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
