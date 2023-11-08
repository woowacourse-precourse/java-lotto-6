package lotto.view;

import static lotto.constant.ErrorMessage.BLANK_INPUT;
import static lotto.constant.ErrorMessage.EXCEEDED_MAXIMUM_NUMBER_FORMAT;
import static lotto.constant.ErrorMessage.INPUT_NOT_DIGIT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private static final String REGEXP_ONLY_NUMBER = "^\\d*$";
    private static final Pattern PATTERN_ONLY_NUMBER = Pattern.compile(REGEXP_ONLY_NUMBER);
    private static final String SPLIT_DELIMITER = ",";

    public Long getPurchaseAmount() {
        String input = readLine();
        validateInputBlank(input);
        validateInputDigit(input);
        return convertInputToPurchasePriceFormat(input);
    }

    public List<Integer> getWinningNumbers() {
        String input = readLine();
        String[] splitInput = input.split(SPLIT_DELIMITER);
        validateNumbersInput(splitInput);
        return convertInputIntoNumbersFormat(splitInput);
    }

    public int getBonusNumber() {
        String input = readLine();
        validateInputBlank(input);
        validateInputDigit(input);
        return convertInputIntoNumberFormat(input);
    }

    private void validateInputBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(BLANK_INPUT.toString());
        }
    }

    private void validateInputDigit(String input) {
        Matcher matcher = PATTERN_ONLY_NUMBER.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INPUT_NOT_DIGIT.toString());
        }
    }

    private void validateNumbersInput(String[] splitInput) {
        for (String number : splitInput) {
            validateInputBlank(number);
            validateInputDigit(number);
        }
    }

    private Long convertInputToPurchasePriceFormat(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(EXCEEDED_MAXIMUM_NUMBER_FORMAT.toString());
        }
    }

    private List<Integer> convertInputIntoNumbersFormat(String[] splitInput) {
        try {
            return Arrays.stream(splitInput)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(EXCEEDED_MAXIMUM_NUMBER_FORMAT.toString());
        }
    }

    private int convertInputIntoNumberFormat(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(EXCEEDED_MAXIMUM_NUMBER_FORMAT.toString());
        }
    }

    private String readLine() {
        return Console.readLine();
    }
}
