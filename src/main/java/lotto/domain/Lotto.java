package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {

    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;
    public static final int COUNT = 6;

    private static final String LOTTO_COUNT_ERROR_MESSAGE = "[ERROR] 로또 번호는 " + COUNT + "개이어야 합니다.";
    private static final String LOTTO_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 " + START_NUMBER + "부터 " + END_NUMBER + " 사이의 숫자여야 합니다.";
    private static final String LOTTO_DUPLICATE_ERROR_MESSAGE = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateCount(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != COUNT) {
            throw new IllegalArgumentException(LOTTO_COUNT_ERROR_MESSAGE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.stream()
                .forEach(this::validateRange);
    }

    private void validateRange(Integer number) {
        if (number < START_NUMBER || number > END_NUMBER) {
            throw new IllegalArgumentException(LOTTO_RANGE_ERROR_MESSAGE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        int nonDuplicatedCount = (int) numbers.stream().distinct().count();
        if (nonDuplicatedCount != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_DUPLICATE_ERROR_MESSAGE);
        }
    }

    public int compareToAnswerLotto(Lotto answerLotto) {
        return (int) numbers.stream()
                .filter(number -> answerLotto.getNumbers().contains(number))
                .count();
    }

    public boolean compareToBonusNumber(int bonusNumber) {
        return numbers.stream()
                .anyMatch(number -> number == bonusNumber);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
