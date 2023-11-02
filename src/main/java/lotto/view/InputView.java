package lotto.view;

import static lotto.constant.Message.LOTTO_PURCHASE_AMOUNT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputLottoPurchaseAmount() {
        System.out.println(LOTTO_PURCHASE_AMOUNT_MESSAGE);
        return Console.readLine();
    }
}
