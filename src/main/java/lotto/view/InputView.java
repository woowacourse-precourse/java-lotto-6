package lotto.view;

import static lotto.util.InputMessage.INPUT_BONUS_NUMBER;
import static lotto.util.InputMessage.INPUT_PURCHASE_AMOUNT;
import static lotto.util.InputMessage.INPUT_WINNING_NUMBER;
import static lotto.util.util.println;

import camp.nextstep.edu.missionutils.Console;

public class InputView {



    public void printInputPurchaseAmountMessage() {
        println(INPUT_PURCHASE_AMOUNT);
    }

    public String inputPurchaseAmount() {
        return Console.readLine();
    }

    public void printInputWinningNumberMessage() {
        println(INPUT_WINNING_NUMBER);
    }

    public String inputWinningNumbers() {
        return Console.readLine();
    }

    public void printInputBonusNumberMessage() {
        println(INPUT_BONUS_NUMBER);
    }

    public String inputBounsNumber() {
        return Console.readLine();
    }
}
