package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.common.InfoMessage.*;
import static lotto.common.validator.*;

public class InputView {

    public int inputPurchaseAmount() {
        System.out.println(PURCHASE_PRICE_INPUT.getMessage());
        String userPurchaseAmout = Console.readLine();
        return isValidPurchaseAmout(userPurchaseAmout);
    }

}
