package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static lotto.util.ErrorMessage.*;

public class UserInputValidation {

    public static int isValidPurchaseAmount(String input) {
        try {
            int result = Integer.parseInt(input);

            isValidInputMultiplesOf1000(result);

            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_STRING_ERROR.getMessage());
        }
    }

    private static void isValidInputMultiplesOf1000(int input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException(INPUT_MULTIPLES_OF_1000_ERROR.getMessage());
        }
    }

    public static ArrayList<Integer> isValidWinningNumber(String input) {
        String result[] = input.split(",");

        isValidWinningNumberLength(result);

        ArrayList<Integer> convertedInput = convertWinningNumberByInt(result);
        convertedInput.stream().forEach(element -> {
            isValidWinningNumber(element);
        });

        return convertedInput;
    }

    private static void isValidWinningNumberLength(String result[]) {
        if (result.length != 6) {
            throw new IllegalArgumentException(INPUT_WINNING_NUMBER_ERROR.getMessage());
        }
    }

    private static ArrayList<Integer> convertWinningNumberByInt(String input[]) {
        return Arrays.stream(input).map(element -> {
                    try {
                        return Integer.parseInt(element);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException(INPUT_STRING_ERROR.getMessage());
                    }
                })
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private static void isValidWinningNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(WINNING_NUMBER_RANGE_ERROR.getMessage());
        }
    }

    public static int isValidBonusNumber(String input) {
        try {
            int result = Integer.parseInt(input);

            isValidWinningNumber(result);

            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_STRING_ERROR.getMessage());
        }
    }

}
