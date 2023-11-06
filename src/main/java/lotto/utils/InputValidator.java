package lotto.utils;

import lotto.constants.ExceptionMessages;

import java.util.List;
import java.util.stream.Stream;

public class InputValidator {
    private static final char LOTTO_NUMBER_SEPARATOR = ',';
    private static final int NUMBER_OF_SEPARATOR = 5;

    public String preprocessUserInput(String userInput) {
        if (isNull(userInput)) {
            ExceptionMessages.NULL_INPUT.throwException();
        }
        if (isEmpty(userInput)) {
            ExceptionMessages.EMPTY_INPUT.throwException();
        }
        String preprocessedInput = removeSpacing(userInput);
        isNonNumeric(preprocessedInput);
        return preprocessedInput;
    }

    public int convertInputToPaymentAmount(String preprocessedInput) {
        return castStringToInt(preprocessedInput);
    }

    public List<Integer> convertInputToLottoNumbers(String preprocessedInput) {
        return castingStringToIntegerList(preprocessedInput);
    }

    public Integer convertInputToBonusNumber(String preprocessedInput) {
        return castingStringToInteger(preprocessedInput);
    }

    private int castStringToInt(String preprocessedInput) {
        return Integer.parseInt(preprocessedInput);
    }

    private List<Integer> castingStringToIntegerList(String preprocessedInput) {
        if (isNotEnoughSeparators(preprocessedInput)) {
            ExceptionMessages.WRONG_SEPARATOR_NUMBERS.throwException();
        }
        List<Integer> convertedInput =
        Stream.of(preprocessedInput.split(String.valueOf(LOTTO_NUMBER_SEPARATOR)))
                .mapToInt(Integer::parseInt)
                .boxed().toList();
        return convertedInput;
    }

    private Integer castingStringToInteger(String preprocessedInput) {
        if (isNotOneElement(preprocessedInput)) {
            ExceptionMessages.WRONG_AMOUNT_BONUS_NUMBERS.throwException();
        }
        return Integer.parseInt(preprocessedInput);
    }

    private boolean isNotEnoughSeparators(String preprocessedInput) {
        int separatorCount = (int) preprocessedInput.chars()
                .filter(inputString -> inputString == LOTTO_NUMBER_SEPARATOR)
                .count();
        return separatorCount != NUMBER_OF_SEPARATOR;
    }

    private boolean isNotOneElement(String preprocessedInput) {
        return preprocessedInput.contains(String.valueOf(LOTTO_NUMBER_SEPARATOR));
    }

    private boolean isNull(String userInput) {
        return userInput == null;
    }

    private boolean isEmpty(String userInput) {
        return userInput.isEmpty();
    }

    private void isNonNumeric(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            ExceptionMessages.NOT_NUMERIC_INPUT.throwException();
        }
    }

    private String removeSpacing(String userInput) {
        return userInput.replaceAll(" ", "");
    }
}
