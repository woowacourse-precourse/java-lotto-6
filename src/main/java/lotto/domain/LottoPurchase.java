package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoConstant;
import lotto.exception.ExceptionMessage;
import lotto.generator.LottoGenerator;

public class LottoPurchase {

    private long purchaseAmount;

    public LottoPurchase(long purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validatePurchaseAmount(long purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.NON_POSITIVE_PURCHASE_AMOUNT);
        }

        if (purchaseAmount % LottoConstant.LOTTO_TICKET_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_DIVISIBLE_BY_LOTTO_TICKET_PRICE);
        }
    }

    public List<Lotto> purchase(LottoGenerator lottoGenerator) {
        long numTickets = purchaseAmount / LottoConstant.LOTTO_TICKET_PRICE;
        List<Lotto> lottoTickets = new ArrayList<>();
        for (long i = 0; i < numTickets; ++i) {
            lottoTickets.add(lottoGenerator.generate());
        }

        return lottoTickets;
    }

    public long getPurchaseAmount() {
        return purchaseAmount;
    }
}
