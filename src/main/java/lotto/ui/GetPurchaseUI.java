package lotto.ui;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.Constants;
import lotto.Purchase;

public class GetPurchaseUI {

    private static String enterPurchaseAmountUI() {

        System.out.println(Constants.ENTER_PURCHASE_AMOUNT);

        return readLine();
    }

    public Purchase getPurchaseAmount() {

        String input = enterPurchaseAmountUI();

        return new Purchase(input);
    }
}
