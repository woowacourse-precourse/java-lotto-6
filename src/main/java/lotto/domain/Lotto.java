package lotto.domain;

import static lotto.domain.Lotto.LottoErrorMessage.COUNT_NOT_SIX;
import static lotto.domain.Lotto.LottoErrorMessage.HAS_DUPLICATE_NUBMER;
import static lotto.domain.Lotto.LottoErrorMessage.NOT_IN_RANGE;
import static lotto.domain.constant.DomainConstant.MAX_RANGE;
import static lotto.domain.constant.DomainConstant.MIN_RANGE;
import static lotto.domain.constant.DomainConstant.SIX;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(final List<Integer> numbers) {
        if (numbers.size() != SIX) {
            throw new IllegalArgumentException(COUNT_NOT_SIX.getErrorMessage());
        }
        if (hasDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(HAS_DUPLICATE_NUBMER.getErrorMessage());
        }
        if (hasNumberNotInRange(numbers)) {
            throw new IllegalArgumentException(NOT_IN_RANGE.getErrorMessage());
        }
    }

    private boolean hasNumberNotInRange(final List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number < MIN_RANGE || number > MAX_RANGE);
    }

    private boolean hasDuplicateNumber(final List<Integer> numbers) {
        final List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .toList();

        return !distinctNumbers.equals(numbers);
    }

    public boolean isContain(final Integer number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    enum LottoErrorMessage {
        COUNT_NOT_SIX("[ERROR] 6개의 숫자로 이루어져야 합니다."),
        HAS_DUPLICATE_NUBMER("[ERROR] 중복된 숫자는 존재할 수 없습니다."),
        NOT_IN_RANGE("[ERROR] 모든 숫자는 1부터 45까지의 값만 가능합니다.");

        private final String errorMessage;

        LottoErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        public String getErrorMessage() {
            return errorMessage;
        }
    }
}
