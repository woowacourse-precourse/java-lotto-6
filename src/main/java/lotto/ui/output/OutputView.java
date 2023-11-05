package lotto.ui.output;

import static lotto.ui.constant.MessageConst.PURCHASE_REQUEST;
import static lotto.ui.constant.MessageConst.WINNING_MAIN_REQUEST;

public class OutputView {

    public static void printPurchaseRequest() {
        System.out.println(PURCHASE_REQUEST);
    }

    public static void printWinningMainRequest() {
        System.out.println(WINNING_MAIN_REQUEST);
    }
}
