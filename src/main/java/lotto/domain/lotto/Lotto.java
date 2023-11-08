package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;

import static lotto.domain.lotto.LottoCondition.*;

public class Lotto {

    private static final String LOTTO_NUMBER_COUNT_ERROR_MESSAGE = "로또 번호는 " + COUNT.getValue() + "개이어야 합니다.";
    private static final String LOTTO_NUMBER_RANGE_ERROR_MESSAGE = "로또 번호는 " + MIN_NUMBER.getValue() + "부터 " + MAX_NUMBER.getValue() + " 사이의 숫자여야 합니다.";
    private static final String LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE = "로또 번호는 중복될 수 없습니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateCount(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != COUNT.getValue()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_ERROR_MESSAGE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.stream()
                .forEach(this::validateRange);
    }

    private void validateRange(Integer number) {
        if (number < MIN_NUMBER.getValue() || number > MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        int nonDuplicatedCount = (int) numbers.stream().distinct().count();
        if (nonDuplicatedCount != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }

    public int compareToLottoNumbers(Lotto lotto) {
        return (int) numbers.stream()
                .filter(number -> lotto.getNumbers().contains(number))
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
