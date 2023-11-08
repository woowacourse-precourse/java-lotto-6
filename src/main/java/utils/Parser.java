package utils;

import error.NotValidNumberInputException;
import error.NotValidWinningNumberInputException;
import type.ErrorType;

import java.util.Arrays;
import java.util.List;

public class Parser {

    public static final String COMMA = ",";
    public static final String INT_REGEX = "^[0-9]+$";
    public static final String COMMA_REGEX = "^(\\d{1,2},){5}\\d{1,2}$";

    public static int convertNumberInput(String input) {
        if (!input.matches(INT_REGEX)) {
            System.out.println(ErrorType.INVALID_NUMBER_INPUT.getText());
            throw new NotValidNumberInputException();
        }
        return Integer.parseInt(input);
    }

    public static List<Integer> convertWinningNumberInput(String input) {
        if (!input.matches(COMMA_REGEX)) {
            System.out.println(ErrorType.INVALID_WINNING_NUMBER_INPUT.getText());
            throw new NotValidWinningNumberInputException();
        }
        return Arrays.stream(input.split(COMMA))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }
}
