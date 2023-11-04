package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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

        isDuplicatedInput(convertedInput);

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

    public static int isValidBonusNumber(String input , ArrayList<Integer> winningNumbers) {
        try {
            int result = Integer.parseInt(input);

            isValidWinningNumber(result);
            isDuplicatedInput(result , winningNumbers);

            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_STRING_ERROR.getMessage());
        }
    }

    private static void isDuplicatedInput(int input , ArrayList<Integer> winningNumbers) {
        if(winningNumbers.contains(input)) {
            throw new IllegalArgumentException(DUPLICATED_WINNING_NUMBER_ERROR.getMessage());
        }
    }

    private static void isDuplicatedInput(ArrayList<Integer> winningNumbers) {
        HashSet<Integer> hashSet = new HashSet<>(winningNumbers);

        if(hashSet.size() != winningNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATED_WINNING_NUMBER_ERROR.getMessage());
        }
    }

}
