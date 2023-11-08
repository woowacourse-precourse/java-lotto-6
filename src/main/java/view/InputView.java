package view;

import Constant.ErrorMessage;
import Constant.ViewMessage;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static int askPurchaseAmount() {
        System.out.println(ViewMessage.ASK_PURCHASE_AMOUNT.getMessage());
        String userInput = Console.readLine().trim();
        System.out.println();
        return validateNumber(userInput);
    }

    public static List<Integer> askWinningNumbers() {
        System.out.println(ViewMessage.ASK_WINNING_NUMBERS.getMessage());
        List<Integer> winningNumbers = new ArrayList<>();
        for (String num : Console.readLine().trim().split(",")) {
            winningNumbers.add(validateNumber(num));
        }
        System.out.println();
        return winningNumbers;
    }

    public static int askBonusNumber() {
        System.out.println(ViewMessage.ASK_BONUS_NUMBER.getMessage());
        String userInput = Console.readLine().trim();
        System.out.println();
        return validateNumber(userInput);
    }

    public static int validateNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_VALUE.getMessage());
        }
    }
}
