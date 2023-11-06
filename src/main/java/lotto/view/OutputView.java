package lotto.view;

import static lotto.util.util.println;

public class OutputView {
    public static String PURCHASE_QUANTITY_MESSAGE = "개를 구매했습니다.";

    public void printPurchaseQyantity(int quantity) {
        println(quantity + PURCHASE_QUANTITY_MESSAGE);
    }
}
