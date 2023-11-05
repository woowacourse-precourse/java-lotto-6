package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.ErrorMessages;

import static lotto.constant.DisplayMessages.*;

public class InputView {

    public static int PurchaseAmount() {
        System.out.println(LOTTO_PURCHASE_AMOUNT.getMessage());
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.PREFIX.getMessage() +
                    ErrorMessages.INVALID_TYPE.getMessage() +
                    ErrorMessages.SUFFIX.getMessage());
        }
    }

    public static String WinningNumber() {
        System.out.println(REQUEST_WINNING_NUMBER.getMessage());
        return Console.readLine();
    }

    public static int BonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER.getMessage());
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.PREFIX.getMessage() +
                    ErrorMessages.INVALID_TYPE.getMessage() +
                    ErrorMessages.SUFFIX.getMessage());
        }
    }
}
