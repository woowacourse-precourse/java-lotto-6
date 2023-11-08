package lotto.view;

import static lotto.view.constant.ViewConstant.InputViewConstant.COMMA;
import static lotto.view.constant.ViewConstant.InputViewConstant.InputErrorMessage.DUPLICATED_WINNING_NUMBER;
import static lotto.view.constant.ViewConstant.InputViewConstant.InputErrorMessage.NOT_EXIST_INPUT_ERROR;
import static lotto.view.constant.ViewConstant.InputViewConstant.InputErrorMessage.NOT_SIX_NUMBERS;
import static lotto.view.constant.ViewConstant.InputViewConstant.InputErrorMessage.WINNING_NUMBERS_INVALID_FORMAT;
import static lotto.view.constant.ViewConstant.InputViewConstant.NUMBERS_COUNT;
import static lotto.view.constant.ViewConstant.InputViewConstant.WINNING_NUMBER_FORMAT_REGEX;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class WinningNumberInputView implements LottoInputViewable, Supplier<String> {
    @Override
    public String get() {
        return receiveInput();
    }

    @Override
    public void validate(final String input) {
        validateFormat(input);
        validateEachNumber(input);
    }

    private void validateFormat(final String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(NOT_EXIST_INPUT_ERROR.getErrorMessage());
        }
        if (isInvalidNumbersFormat(input)) {
            throw new IllegalArgumentException(WINNING_NUMBERS_INVALID_FORMAT.getErrorMessage());
        }
        if (hasNotSixNumbers(input)) {
            throw new IllegalArgumentException(NOT_SIX_NUMBERS.getErrorMessage());
        }
        if (hasDuplicateNumber(input)) {
            throw new IllegalArgumentException(DUPLICATED_WINNING_NUMBER.getErrorMessage());
        }
    }

    private boolean isInvalidNumbersFormat(final String winningNumber) {
        return !winningNumber.matches(WINNING_NUMBER_FORMAT_REGEX);
    }

    private boolean hasNotSixNumbers(final String winningNumber) {
        return winningNumber.split(COMMA).length != NUMBERS_COUNT;
    }

    private boolean hasDuplicateNumber(String winningNumber) {
        List<String> numbers = Arrays.asList(winningNumber.split(COMMA));
        Set<String> nonDuplicateNumbers = new HashSet<>(numbers);
        return nonDuplicateNumbers.size() != numbers.size();
    }

    private void validateEachNumber(final String winningNumber) {
        final List<String> numbers = Arrays.asList(winningNumber.split(COMMA));
        try {
            numbers.forEach(this::validateLottoNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
