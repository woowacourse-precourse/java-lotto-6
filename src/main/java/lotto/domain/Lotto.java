package lotto.domain;

import static lotto.common.ErrorMessages.DUPLICATE_NUMBERS_MESSAGE;
import static lotto.common.ErrorMessages.INVALID_NUMBERS_COUNT_MESSAGE;
import static lotto.common.ErrorMessages.INVALID_WINNING_NUMBER_MESSAGE;
import static lotto.common.ErrorMessages.NULL_OR_EMPTY;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.InputValidationException;
import org.junit.platform.commons.util.StringUtils;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public static Lotto createLotto(String winningNumbers) {
        validateWinningNumbers(winningNumbers);

        return new Lotto(Arrays.stream(winningNumbers.split(","))
                .map(winningNumber -> Integer.parseInt(winningNumber))
                .collect(Collectors.toList()));
    }

    private static void validateWinningNumbers(String winningNumbers) {
        if (StringUtils.isBlank(winningNumbers)) {
            throw new InputValidationException(NULL_OR_EMPTY);
        }

        if (!winningNumbers.matches("^[0-9,]+$")) {
            throw new InputValidationException(INVALID_WINNING_NUMBER_MESSAGE);
        }
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new InputValidationException(INVALID_NUMBERS_COUNT_MESSAGE);
        }

        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new InputValidationException(DUPLICATE_NUMBERS_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int getCountingMatchingNumbers(Lotto lotto) {
        int count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (containsNumber(lotto.getNumbers().get(i))) {
                count++;
            }
        }
        return count;
    }

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }
}
