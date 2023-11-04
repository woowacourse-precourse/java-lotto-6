package lotto.util;

import static lotto.constant.LottoInfo.ONE_LOTTO_PRICE;

import lotto.vo.PurchaseAmount;
import lotto.vo.TicketQuantity;

public class Converter {

    private Converter() {
    }

    public static TicketQuantity convertToTicketCount(final Integer amount) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount);
        Integer quantity = getTicketCount(purchaseAmount);

        return new TicketQuantity(quantity);
    }

    private static Integer getTicketCount(final PurchaseAmount purchaseAmount) {
        return Integer.valueOf(purchaseAmount.amount()) / ONE_LOTTO_PRICE.getValue();
    }
}
