package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static constant.MessageList.INPUT_PURCHASE_AMOUNT_MESSAGE;

public class InputView {
    public static String getPurchaseAmountInputFromPlayer() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        return Console.readLine();
    }
}
