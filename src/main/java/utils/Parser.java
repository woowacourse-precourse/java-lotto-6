package utils;

import type.ErrorType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    public static final String COMMA = ",";

    public static int convertNumberInput(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException(ErrorType.INVALID_NUMBER_INPUT.getText());
        }

        int convertMoney = Integer.parseInt(input);
        Validator.checkMoney(convertMoney);
        return convertMoney;
    }

    public static List<Integer> convertWinningNumberInput(String input) {
        if (!input.matches("^(\\d{1,2},){5}\\d{1,2}$")) {
            throw new IllegalArgumentException(ErrorType.INVALID_WINNING_NUMBER_INPUT.getText());
        }
        return Arrays.stream(input.split(COMMA))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }
}
