package lottoTicketPurchase;

import static constant.GeneralMessage.PURCHASE_QUANTITY_PRINT_MESSAGE;
import static constant.Number.PURCHASE_UNIT;

public class LottoTicketQuantity {
    public int getPurchaseQuantity(int purchaseAmount) {
        return purchaseAmount / PURCHASE_UNIT;
    }

    public void printPurchaseQuantity(int purchaseQuantity) {
        System.out.println(purchaseQuantity + PURCHASE_QUANTITY_PRINT_MESSAGE);
    }
}