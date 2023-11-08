package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.util.message.InputMessage.*;
public class InputView {
    public String lottoPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT.getInputMessage());
        return Console.readLine();
    }
    public String winnerNumbers() {
        System.out.println(INPUT_WINNING_NUMBER.getInputMessage());
        return Console.readLine();
    }
    public String bonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER.getInputMessage());
        return Console.readLine();
    }
}
