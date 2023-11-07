package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static Integer inputPurchaseAmount() {
        System.out.println(MessageConstants.PURCHASE_AMOUNT_GUIDE);
        String inputValue = Console.readLine();
        return Integer.parseInt(inputValue);
    }

    public static String inputWinningNumbers() {
        System.out.println(MessageConstants.WINNING_NUMBERS_GUIDE);
        String inputValue = Console.readLine();
        return inputValue;
    }

    public static String inputBonusNumber() {
        System.out.println(MessageConstants.BONUS_NUMBER_GUIDE);
        String inputValue = Console.readLine();
        return inputValue;
    }
}
