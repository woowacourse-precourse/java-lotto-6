package lotto.ui;

import static lotto.contents.ContentStrings.INPUT_BONUS_NUMBER;
import static lotto.contents.ContentStrings.INPUT_PURCHASE_AMOUNT;
import static lotto.contents.ContentStrings.INPUT_WINNING_NUMBERS;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT.getValue());
        return Console.readLine();
    }

    public static String inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS.getValue());
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER.getValue());
        return Console.readLine();
    }
}


