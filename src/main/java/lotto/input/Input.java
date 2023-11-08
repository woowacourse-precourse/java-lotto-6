package lotto.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private static void print(InputMessage message) {
        System.out.println(message.getMessage());
    }

    private static void printEnterPurchaseAmount() {
        print(InputMessage.ENTER_PURCHASE_AMOUNT);
    }

    private static void printEnterWinningNumbers() {
        print(InputMessage.ENTER_WINNING_NUMBERS);
    }

    private static void printEnterBonusNumber() {
        print(InputMessage.ENTER_BONUS_NUMBER);
    }

    public static int getPurchaseAmount() {
        printEnterPurchaseAmount();
        String purchaseAmount = Console.readLine();
        InputValidator.isValidPurchaseAmount(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println();
        printEnterWinningNumbers();
        String[] winningNumbers = Console.readLine().split(",");

        for (int i = 0; i < winningNumbers.length; i++) {
            winningNumbers[i] = winningNumbers[i].trim();
        }
        InputValidator.isValidWinningNumbers(winningNumbers);

        List<Integer> numbers = new ArrayList<>();
        for (String number : winningNumbers) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }

    public static int getBonusNumber() {
        System.out.println();
        printEnterBonusNumber();
        String bonusNumber = Console.readLine();
        InputValidator.isValidBonusNumber(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }
}
