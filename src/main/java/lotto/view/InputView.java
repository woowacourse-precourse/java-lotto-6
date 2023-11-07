package lotto.view;

import static lotto.constant.PrintMessage.LOTTO_PURCHASE_AMOUNT;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String readLottoPurchaseAmount() {
        System.out.println(LOTTO_PURCHASE_AMOUNT);
        return Console.readLine();
    }

}
