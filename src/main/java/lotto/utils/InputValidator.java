package lotto.utils;

import lotto.exception.inputvalidator.NonIntegerNumberException;
import lotto.exception.inputvalidator.NonNumericInputException;

import java.util.Arrays;
import java.util.List;

public class InputValidator {

    private static final String LOTTO_NUMBER_SEPARATOR = ",";

    public static void validateAmountNotNumber(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new NonNumericInputException();
        }
    }

    public static void validateAnswerNumberIsNumber(String answerNumber) {
        List<String> answerNumbers = parseAnswerNumberToList(answerNumber);
        validateNumbersAreInteger(answerNumbers);
    }

    private static List<String> parseAnswerNumberToList(String answerNumber) {
        return Arrays.stream(answerNumber.split(LOTTO_NUMBER_SEPARATOR))
                .filter(s -> !s.isEmpty())
                .toList();
    }

    private static void validateNumbersAreInteger(List<String> numbers) {
        for (String number : numbers) {
            try {
                Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new NonIntegerNumberException();
            }
        }
    }
}
