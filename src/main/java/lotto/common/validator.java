package lotto.common;

import java.util.ArrayList;
import java.util.List;

import static lotto.common.ErrorMessage.*;

public class validator {

    public static int isValidPurchaseAmout(String amoutInput) {
        try {
            int price = Integer.parseInt(amoutInput);
            if (price % 1000 != 0) {
                throw new IllegalArgumentException(INPUT_MULTIPLES_ERROR.getMessage());
            }
            return price;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_TYPE_STRING_ERROR.getMessage());
        }
    }

    public static List<Integer> isValidWinningNumber(String input) {
        List<String> winningNums = List.of(input.split(","));
        List<Integer> intWinningNums = new ArrayList<>();
        checkWinningNumsLength(winningNums);
        return getIntWinningNums(winningNums, intWinningNums);
    }

    public static int isValidBonusNumber(String input) {
        try {
            int bounusNum = Integer.parseInt(input);
            return bounusNum;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_TYPE_STRING_ERROR.getMessage());
        }
    }

    private static List<Integer> getIntWinningNums(List<String> winningNums, List<Integer> intWinningNums) {
        try {
            for (String num : winningNums) {
                int winningNum = Integer.parseInt(num);
                intWinningNums.add(winningNum);
            }
            return intWinningNums;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_TYPE_STRING_ERROR.getMessage());
        }
    }

    private static void checkWinningNumsLength(List<String> winningNums) {
        if (winningNums.size() != 6) {
            throw new IllegalArgumentException(INPUT_WINNING_NUMBER_LENGTH_ERROR.getMessage());
        }
    }


}
