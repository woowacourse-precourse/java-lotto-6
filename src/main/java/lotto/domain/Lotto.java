package lotto.domain;

import static java.lang.String.format;
import static java.util.function.Predicate.isEqual;
import static java.util.stream.Collectors.toList;
import static lotto.constants.NumberConstant.LAST_INDEX_FOR_INSERT_SEPARATOR;
import static lotto.constants.NumberConstant.MAXIMUM_LOTTO_NUMBER;
import static lotto.constants.NumberConstant.MINIMUM_LOTTO_NUMBER;
import static lotto.constants.NumberConstant.VALIDATE_LOTTO_SIZE;
import static lotto.constants.NumberConstant.ZERO;
import static lotto.constants.SeparatorConstant.LOTTO_NUMBERS_SEPARATOR;
import static lotto.enums.ConsoleMessage.LOTTO_PRINT_FORMAT;
import static lotto.enums.ExceptionMessage.DUPLICATE_NUMBER_ERROR;
import static lotto.enums.ExceptionMessage.LOTTO_NUMBER_OUT_OF_RANGE;
import static lotto.enums.ExceptionMessage.WINNING_NUMBERS_SIZE_ERROR;

import java.util.List;
import lotto.exception.LottoGameException;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = sorted(numbers);
    }

    public boolean contains(final Integer number) {
        return numbers.stream()
                .anyMatch(isEqual(number));
    }

    public long countMatchingWinningNumbers(final Lotto anotherLotto) {
        return numbers.stream()
                .filter(anotherLotto::contains)
                .count();
    }

    private List<Integer> sorted(final List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(toList());
    }

    private void validate(final List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void validateRange(final List<Integer> numbers) {
        if (numberOutOfRange(numbers)) {
            throw LottoGameException.from(LOTTO_NUMBER_OUT_OF_RANGE);
        }
    }

    private boolean numberOutOfRange(final List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(this::isNumberOutOfRange);
    }

    private boolean isNumberOutOfRange(final int number) {
        return number < MINIMUM_LOTTO_NUMBER || number > MAXIMUM_LOTTO_NUMBER;
    }

    private void validateDuplicate(final List<Integer> numbers) {
        if (hasDuplicate(numbers)) {
            throw LottoGameException.from(DUPLICATE_NUMBER_ERROR);
        }
    }

    private boolean hasDuplicate(final List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != VALIDATE_LOTTO_SIZE;
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers.size() != VALIDATE_LOTTO_SIZE) {
            throw LottoGameException.from(WINNING_NUMBERS_SIZE_ERROR);
        }
    }

    private String appendLottoNumbers() {
        final StringBuilder sb = new StringBuilder();
        for (int index = ZERO; index < VALIDATE_LOTTO_SIZE; index++) {
            appendLottoNumber(sb, index);
        }
        return sb.toString();
    }

    private void appendLottoNumber(StringBuilder sb, int index) {
        sb.append(numbers.get(index));
        if (index < LAST_INDEX_FOR_INSERT_SEPARATOR) {
            sb.append(LOTTO_NUMBERS_SEPARATOR);
        }
    }

    @Override
    public String toString() {
        return format(LOTTO_PRINT_FORMAT.getMessage(), appendLottoNumbers());
    }
}
