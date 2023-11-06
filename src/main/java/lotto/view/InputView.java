package lotto.view;

import static lotto.util.content.DisplayMessage.SET_PURCHASE_AMOUNT;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Censor;

public class InputView {

    public static String purchaseAmount() {
        System.out.println(SET_PURCHASE_AMOUNT.getContent());
        return Censor.commonValid(Console.readLine());
    }

}
