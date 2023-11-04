package lotto.view;

import static lotto.view.constants.Notice.PURCHASE_RESULT;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    public static void printPurchaseResult(List<Lotto> lottos) {
        int quantity = lottos.size();
        System.out.println();
        System.out.println(quantity + PURCHASE_RESULT.getMessage());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }
}
