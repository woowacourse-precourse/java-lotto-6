package lotto.model;

import static lotto.utils.Constants.ERROR_MESSAGE;
import static lotto.utils.Constants.MAX_NUMBER;
import static lotto.utils.Constants.MIN_NUMBER;
import static lotto.utils.Constants.WINNING_NUMBER_DUPLICATE_ERROR;
import static lotto.utils.Constants.WINNING_NUMBER_ERROR;
import static lotto.utils.Constants.WINNING_NUMBER_PATTERN;
import static lotto.utils.Constants.WINNING_NUMBER_RANGE_ERROR;
import static lotto.utils.Constants.WINNING_NUMBER_STRING_ERROR;
import static lotto.utils.Constants.WINNING_NUMBER_STRING_PATTERN;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;

public class WinningNumberValidator {
    String winningNumber;
    List<String> numbers;

    public WinningNumberValidator(String winningNumber) {
        this.winningNumber = winningNumber;
        this.numbers = Arrays.asList(winningNumber.split(","));
        validate();
    }

    private void validate() {
        isCorrectPattern();
        isNumber();
        isCorrectRange();
        isDuplicate();
    }

    private void isCorrectPattern() {
        Matcher matcher = WINNING_NUMBER_STRING_PATTERN.matcher(winningNumber);
        if (!matcher.find()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + WINNING_NUMBER_STRING_ERROR);
        }
    }

    private void isNumber() {
        numbers.stream()
                .filter(numbers -> !WINNING_NUMBER_PATTERN.matcher(numbers).find())
                .findAny()
                .ifPresent(s -> {
                    throw new IllegalArgumentException(ERROR_MESSAGE + WINNING_NUMBER_ERROR);
                });
    }

    private void isCorrectRange() {
        numbers.stream()
                .map(Integer::parseInt)
                .filter(number -> number < MIN_NUMBER || number > MAX_NUMBER)
                .findAny()
                .ifPresent(number -> {
                    throw new IllegalArgumentException(ERROR_MESSAGE + WINNING_NUMBER_RANGE_ERROR);
                });
    }

    private void isDuplicate() {
        if (numbers.stream().distinct().count() < numbers.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + WINNING_NUMBER_DUPLICATE_ERROR);
        }
    }

}
