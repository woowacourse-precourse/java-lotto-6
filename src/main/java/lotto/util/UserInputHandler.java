package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.constants.ErrorMessages;

public class UserInputHandler {
    public static Integer getLottoPurchaseAmount() {
        boolean isNotEnd = true;
        Integer amount = 0;
        do {
            try {
                amount = amountConvertToInteger(Console.readLine());
                NumberValidator.verifyPurchaseAmount(amount);
                isNotEnd = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (isNotEnd);

        return amount;
    }

    private static Integer amountConvertToInteger(String userInput) {
        NumberValidator.verifyNumberType(userInput, ErrorMessages.LLOTTO_PURCHASE_AMOUNT_NUMERIC_ONLY);
        return Integer.parseInt(userInput);
    }

    public static List<Integer> getWinningNumbers() {
        boolean isNotEnd = true;
        List<Integer> winningNumbers = new ArrayList<>();
        do {
            try {
                List<String> userInputs = List.of(Console.readLine().split(","));
                winningNumbers.addAll(userInputs.stream().map(e -> winningNumbersConvertToInteger(e)).toList());
                NumberValidator.verifyWinningNumbers(winningNumbers);
                isNotEnd = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (isNotEnd);

        return winningNumbers;
    }

    private static Integer winningNumbersConvertToInteger(String userInput) {
        NumberValidator.verifyNumberType(userInput, ErrorMessages.WINNING_NUMBERS_NUMERIC_ONLY);
        return Integer.parseInt(userInput);
    }

    public static Integer getBonusNumber(List<Integer> winningNumbers) {
        boolean isNotEnd = true;
        Integer bonusNumber = 0;
        do {
            try {
                bonusNumber = bonusNumberConvertToInteger(Console.readLine());
                NumberValidator.verifyBonusNumber(winningNumbers, bonusNumber);
                isNotEnd = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (isNotEnd);

        return bonusNumber;
    }

    private static Integer bonusNumberConvertToInteger(String userInput) {
        NumberValidator.verifyNumberType(userInput, ErrorMessages.BONUS_NUMBER_NUMERIC_ONLY);
        return Integer.parseInt(userInput);
    }
}
