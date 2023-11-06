package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;

import static lotto.domain.lotto.LottoCondition.*;

public class Lotto {

    private static final String LOTTO_COUNT_ERROR_MESSAGE = "로또 번호는 " + COUNT.getValue() + "개이어야 합니다.";
    private static final String LOTTO_RANGE_ERROR_MESSAGE = "로또 번호는 " + START_NUMBER.getValue() + "부터 " + END_NUMBER.getValue() + " 사이의 숫자여야 합니다.";
    private static final String LOTTO_DUPLICATE_ERROR_MESSAGE = "로또 번호는 중복될 수 없습니다.";
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
        if (numbers.size() != COUNT.getValue()) {
            throw new IllegalArgumentException(LOTTO_COUNT_ERROR_MESSAGE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.stream()
                .forEach(this::validateRange);
    }

    private void validateRange(Integer number) {
        if (number < START_NUMBER.getValue() || number > END_NUMBER.getValue()) {
            throw new IllegalArgumentException(LOTTO_RANGE_ERROR_MESSAGE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        int nonDuplicatedCount = (int) numbers.stream().distinct().count();
        if (nonDuplicatedCount != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_DUPLICATE_ERROR_MESSAGE);
        }
    }

    public int compareToWinningNumbers(Lotto answerLotto) {
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
