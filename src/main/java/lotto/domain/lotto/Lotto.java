package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;
import lotto.domain.message.ErrorMessage;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateNumberRange(numbers);
        validateDuplication(numbers);
    }

    private void validateSize(List<Integer> numbers) {

        if (numbers.size() != LottoRule.LOTTO_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(
                    ErrorMessage.NUMBERS_SIZE_EXCEPTION_MESSAGE.getMessage());
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (isOutOfRange(numbers)) {
            throw new IllegalArgumentException(
                    ErrorMessage.NUMBER_RANGE_EXCEPTION_MESSAGE.getMessage());
        }

    }

    private boolean isOutOfRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number < LottoRule.LOTTO_MIN_NUMBER_INCLUSION.getValue()
                        || number > LottoRule.LOTTO_MAX_NUMBER_INCLUSION.getValue());
    }

    private void validateDuplication(List<Integer> numbers) {
        if (hasDistinctNumberIn(numbers)) {
            throw new IllegalArgumentException(
                    ErrorMessage.DUPLICATION_EXCEPTION_MESSAGE.getMessage());
        }
    }

    private boolean hasDistinctNumberIn(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .toList()
                .size()
                != numbers.size();
    }

    public int calculateMatchCount(Lotto otherLotto) {
        int result = 0;
        for (int number : numbers) {
            if (otherLotto.hasSameNumber(number)) {
                result++;
            }
        }
        return result;
    }

    //todo : 메서드명 생각해보기
    private boolean hasSameNumber(int number) {
        return numbers.contains(number);
    }

    public boolean hasSameNumber(BonusNumber bonusNumber) {
        return numbers.stream()
                .anyMatch(bonusNumber::hasSameNumber);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
