package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class getPurchaseUI {

    public String enterPurchaseAmountUI() {

        System.out.println(Constants.ENTER_PURCHASE_AMOUNT);

        return readLine();
    }
}
