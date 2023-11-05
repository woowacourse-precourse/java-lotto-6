package lotto.model;

import lotto.exception.Validation;

public class LottoPurchaseManager {

    private static final int LOTTO_TICKET_PRICE = 1000;

    private final int purchaseAmount;
    private int lottoTicketCount;

    public LottoPurchaseManager(int purchaseAmount,
                                int lottoTicketCount) {
        Validation.validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        this.lottoTicketCount = lottoTicketCount;
    }

    public static int getLottoTicketPrice() {
        return LOTTO_TICKET_PRICE;
    }

    public int calculateLottoTicketCount() {
        return this.purchaseAmount / LOTTO_TICKET_PRICE;
    }
}
