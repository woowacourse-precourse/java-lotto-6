package lotto.ui;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.Constants;

public class GetPurchaseUI {

    public String enterPurchaseAmountUI() {

        System.out.println(Constants.ENTER_PURCHASE_AMOUNT);

        return readLine();
    }
}
