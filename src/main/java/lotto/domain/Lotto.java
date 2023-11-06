package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private static final String LOTTO_COUNT_ERROR_MESSAGE = "[ERROR] 로또 번호는 " + LottoInfo.COUNT + "개이어야 합니다.";
    private static final String LOTTO_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 " + LottoInfo.START_NUMBER + "부터 " + LottoInfo.END_NUMBER + " 사이의 숫자여야 합니다.";
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
        if (numbers.size() != LottoInfo.COUNT) {
            throw new IllegalArgumentException(LOTTO_COUNT_ERROR_MESSAGE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.stream()
                .forEach(this::validateRange);
    }

    private void validateRange(Integer number) {
        if (number < LottoInfo.START_NUMBER || number > LottoInfo.END_NUMBER) {
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
        return (int)numbers.stream()
                .filter(number -> answerLotto.getNumbers().contains(number))
                .count();
    }

    public boolean compareToBonusNumber(int bonusNumber) {
        return numbers.stream()
                .filter(number -> number == bonusNumber)
                .findFirst()
                .isPresent();
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
