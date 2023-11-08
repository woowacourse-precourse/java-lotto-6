package view;

import camp.nextstep.edu.missionutils.Console;
import util.ValidationPrice;

public class InputView {

    public static Integer inputPurchasePrice() {
        String message = InputMessages.PURCHASE_MESSAGE.getMessage();
        System.out.println(message);
        String priceString = input();
        ValidationPrice.validatePrice(priceString);
        Integer price = Integer.parseInt(priceString);
        return price;
    }

    public static String inputWinningNumbers() {
        String message = InputMessages.WINNING_NUMBER_MESSAGE.getMessage();
        System.out.println(message);
        String winningNumbers = input();
        return winningNumbers;
    }

    public static String inputBonusNumber() {
        String message = InputMessages.BONUS_NUMBER_MESSAGE.getMessage();
        System.out.println(message);
        String bonusNumber = input();
        return bonusNumber;
    }

    public static String input() {
        return Console.readLine();
    }
}
