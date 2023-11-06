package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static Integer inputPurchasePrice() {
        String message = InputMessages.PURCHASE_MESSAGE.getMessage();
        System.out.println(message);
        Integer price = Integer.parseInt(input());
        return price;
    }

    public static String inputWinningNumbers() {
        String message = InputMessages.WINNING_NUMBER_MESSAGE.getMessage();
        System.out.println(message);
        String winningNumbers = input();
        return winningNumbers;
    }

    public static String input() {
        return Console.readLine();
    }
}
