package lotto.view;

import java.util.List;
import lotto.domain.Buyer;
import lotto.domain.Lotto;

public class OutputView {

    private static final String PURCHASE_QUANTITY_INFORMATION = "개를 구매했습니다.";

    public static void printPurchaseLotto(Buyer buyer) {
        printPurchaseQuantity(buyer.getPurchaselottoQuantity());
        printLottoNumbers(buyer);
    }

    private static void printPurchaseQuantity(int quantity) {
        System.out.println();
        System.out.println(quantity + PURCHASE_QUANTITY_INFORMATION);
    }

    private static void printLottoNumbers(Buyer buyer) {
        for (Lotto lotto : buyer.getLottoTickets()) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }
}
