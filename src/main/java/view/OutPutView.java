package view;

import model.Lotto;
import model.MyLotto;

public class OutPutView {

    private static final String PRINT_PURCHASE_RESULT = "%d개를 구매했습니다.\n";

    public static void printPurchaseResult(MyLotto myLotto) {
        System.out.printf(PRINT_PURCHASE_RESULT, myLotto.getMyLotto().size());
        for (Lotto lotto : myLotto.getMyLotto()) {
            System.out.println(lotto.getSortedNumbers());
        }
    }
}