package lotto.view;

import static lotto.util.content.DisplayMessage.SET_PURCHASE_AMOUNT;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Censor;

public class InputView {

    public static Integer purchaseAmount() {
        System.out.println(SET_PURCHASE_AMOUNT.getContent());
        return Integer.parseInt(Censor.commonValid(Console.readLine()));
    }

}
