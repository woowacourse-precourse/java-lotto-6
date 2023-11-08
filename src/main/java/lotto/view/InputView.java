package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.view.OutputView.*;
import static lotto.common.validator.*;

public class InputView {

    public static int inputPurchaseAmount() {
        System.out.println(PURCHASE_PRICE_REQUEST.getMessage());
        String userPurchaseAmout = Console.readLine();
        return isValidPurchaseAmout(userPurchaseAmout);
    }

}
