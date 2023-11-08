package lotto.view;


import camp.nextstep.edu.missionutils.Console;
import lotto.message.ConsoleMessage;

public class InputView {

    public static int getPurchaseMoney() {
        System.out.println(ConsoleMessage.GET_PURCHASE_MONEY.getMessage());
        int number = validateNumber(Console.readLine());
        System.out.println();
        return number;
    }

    public static String getWinningNumbers() {
        System.out.println(ConsoleMessage.GET_WINNING_NUMBERS.getMessage());
        String winningNumbers = Console.readLine();
        System.out.println();
        return winningNumbers;
    }

    public static int getBonusNumber() {
        System.out.println(ConsoleMessage.GET_BONUS_NUMBER.getMessage());
        int bonusNumber = validateNumber(Console.readLine());
        System.out.println();
        return bonusNumber;
    }

    public static int validateNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ConsoleMessage.LOTTO_NUMBER_RANGE_ERROR.getMessage());
        }
    }
}
