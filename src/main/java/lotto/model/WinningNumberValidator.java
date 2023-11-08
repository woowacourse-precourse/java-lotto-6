package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.utils.Constants;
import lotto.utils.ErrorMessage;
import lotto.utils.Patterns;

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
        Matcher matcher = Pattern.compile(Patterns.WINNING_NUMBER_STRING_PATTERN.getPattern()).matcher(winningNumber);
        if (!matcher.find()) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR_MESSAGE.getMessage() + ErrorMessage.WINNING_NUMBER_STRING_ERROR.getMessage());
        }
    }

    private void isNumber() {
        numbers.stream()
                .filter(numbers -> !Pattern.compile(Patterns.LOTTO_NUMBER_PATTERN.getPattern())
                        .matcher(String.valueOf(numbers)).find())
                .findAny()
                .ifPresent(s -> {
                    throw new IllegalArgumentException(
                            ErrorMessage.ERROR_MESSAGE.getMessage() + ErrorMessage.WINNING_NUMBER_ERROR.getMessage());
                });
    }

    private void isCorrectRange() {
        numbers.stream()
                .map(Integer::parseInt)
                .filter(number -> number < Constants.MIN_NUMBER.getNumber()
                        || number > Constants.MAX_NUMBER.getNumber())
                .findAny()
                .ifPresent(number -> {
                    throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE.getMessage()
                            + ErrorMessage.WINNING_NUMBER_RANGE_ERROR.getMessage());
                });
    }

    private void isDuplicate() {
        if (numbers.stream().distinct().count() < numbers.size()) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR_MESSAGE.getMessage() + ErrorMessage.WINNING_NUMBER_DUPLICATE_ERROR.getMessage());
        }
    }

}
