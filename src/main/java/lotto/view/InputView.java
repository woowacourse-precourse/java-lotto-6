package lotto.view;

import static lotto.enums.Message.INPUT_BONUS_NUMBER_MESSAGE;
import static lotto.enums.Message.INPUT_PURCHASE_AMOUNT_MESSAGE;
import static lotto.enums.Message.INPUT_WINNING_NUMBERS_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public void printInputPurchaseAmountMessage() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE.getMessage());
    }

    public String inputPurchaseAmount() {
        return Console.readLine();
    }

    public String inputWinningNumbers() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE.getMessage());
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE.getMessage());
        return Console.readLine();
    }
}
