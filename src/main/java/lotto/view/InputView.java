package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.InputViewConstant;

public class InputView {
    public static void promptPurchaseAmount() {
        System.out.println(InputViewConstant.PURCHASE_AMOUNT_PROMPT);
    }

    public static String readPurchaseAmount() {
        String input = Console.readLine();
        System.out.println();
        return input;
    }

    public static void promptWinningNumbers() {
        System.out.println(InputViewConstant.WINNING_NUMBERS_PROMPT);
    }

    public static String readWinningNumbers() {
        String input = Console.readLine();
        System.out.println();
        return input;
    }

    public static void promptBonusNumber() {
        System.out.println(InputViewConstant.BONUS_NUMBER_PROMPT);
    }

    public static String readBonusNumber() {
        String bonusNumber = Console.readLine();
        System.out.println();
        return bonusNumber;
    }
}
