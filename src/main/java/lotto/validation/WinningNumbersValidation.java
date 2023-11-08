package lotto.validation;

import lotto.constant.ErrorMessage;
import lotto.constant.NumberUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbersValidation {
    NumericInputValidation numericInputValidation = new NumericInputValidation();

    public List<Integer> validateWinnerNumbers(String input) {
        validateInputUseCorrectSeparator(input);
        validateWinnerNumbersNumeric(input);
        validateWinnerNumbersPositive(input);
        List<Integer> winnerNumbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        validateWinnerNumbersOutOfRange(winnerNumbers);
        validateDuplicateWinnerNumbers(winnerNumbers);

        return winnerNumbers;
    }

    public void validateInputUseCorrectSeparator(String input) {
        String deleteAllWords = input.replaceAll("[가-힣a-zA-Z0-9,-]", "");
        if (deleteAllWords.length() != 0) {
            throw new IllegalArgumentException(ErrorMessage
                    .CORRECT_SEPARATOR_INPUT_ERROR_MESSAGE
                    .getMessage());
        }
    }

    public void validateWinnerNumbersNumeric(String input) {
        String exceptSeperator = input.replaceAll("[,-]", "");
        numericInputValidation.validateInputIsNumeric(exceptSeperator);
    }

    public void validateWinnerNumbersPositive(String input) {
        String[] winnerNumbers = input.split(",");

        validateCheckRangeOfWinnerNumberInput(winnerNumbers);

        if (Arrays.stream(winnerNumbers).anyMatch(number ->
                Integer.parseInt(number) < NumberUtil.MIN_NUMBER.getNumber())) {
            throw new IllegalArgumentException(ErrorMessage
                    .POSITIVE_LOTTO_NUMBER_CONSTRAINT_MESSAGE
                    .getMessage());
        }
    }

    public void validateCheckRangeOfWinnerNumberInput(String[] input) {
        try {
            for (String number : input) {
                Integer.parseInt(number);
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException(ErrorMessage
                    .WINNING_NUMBER_OUT_OF_RANGE_MESSAGE
                    .getMessage());
        }
    }

    public void validateWinnerNumbersOutOfRange(List<Integer> winnerNumbers) {
        if (winnerNumbers.stream().anyMatch(number ->
                number < NumberUtil.START_NUMBER.getNumber() ||
                        number > NumberUtil.END_NUMBER.getNumber())) {
            throw new IllegalArgumentException(ErrorMessage
                    .WINNING_NUMBER_OUT_OF_RANGE_MESSAGE
                    .getMessage());
        }
    }

    public void validateDuplicateWinnerNumbers(List<Integer> winnerNumbers) {

        Set<Integer> numbers = new HashSet<>(winnerNumbers);

        if (winnerNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage
                    .DUPLICATE_NUMBER_CONSTRAINT_MESSAGE
                    .getMessage());
        }
    }
}
