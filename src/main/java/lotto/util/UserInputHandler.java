package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import lotto.constants.ErrorMessages;

public class UserInputHandler {
    public static Integer getLottoPurchaseAmount() {
        boolean isNotEnd = true;
        Integer amount = 0;
        do {
            try {
                amount = convertToInteger(Console.readLine());
                isNotEnd = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (isNotEnd);

        return amount;
    }

    private static Integer convertToInteger(String userInput) {
        NumberValidator.verifyNumberType(userInput, ErrorMessages.LLOTTO_PURCHASE_AMOUNT_NUMERIC_ONLY);
        return Integer.parseInt(userInput);
    }

    public static List<Integer> getWinningNumbers() {
        boolean isNotEnd = true;
        List<Integer> winningNumbers = new ArrayList<>();
        do {
            try {
                List<String> userInputs = List.of(Console.readLine().split(","));
                winningNumbers.addAll(userInputs.stream().map(e -> convertToInteger(e)).toList());
                isNotEnd = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (isNotEnd);

        return winningNumbers;
    }
}
