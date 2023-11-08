package lotto.controller;

import static lotto.util.Constants.TICKET_MINIMUN_PRICE;
import static lotto.util.Constants.WINNING_NUMBER_AMOUNT;

import java.util.ArrayList;
import java.util.List;
import lotto.util.ErrorMessage;

public class Validator {

    public static int isNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER);
        }

    }

    public static void isThousandUnit(int input) {
        if (input % TICKET_MINIMUN_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_THOUSAND_UNIT);
        }
    }

    public static int isValidRange(int input) {
        if (input < 1 || input > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE);
        }
        return input;
    }

    public static List<Integer> isSixNumber(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUMBER_AMOUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT);
        }
        return numbers;
    }

    public static int validatePurchaseAmount(String input) {
        int purchasePrice = isNumber(input);
        isThousandUnit(purchasePrice);
        return purchasePrice;
    }

    public static List<Integer> validateWinningNumber(String input) {
        String[] parse = input.split(",");
        List<Integer> winningNumber = new ArrayList<>();
        for (String part : parse) {
            int number = isNumber(part);
            winningNumber.add(number);
        }
        return isSixNumber(winningNumber);
    }

    public static int validateBonusNumber(String input, List<Integer> winningNumber) {
        int bonusNumber = isNumber(input);
        isValidRange(bonusNumber);
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATE);
        }
        return isValidRange(bonusNumber);
    }
}
