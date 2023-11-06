package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchase {

    private long purchaseAmount;

    public LottoPurchase(long purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validatePurchaseAmount(long purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("로또 구입 금액은 양수여야 합니다.");
        }

        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("로또 구입 금액은 " +
                    LottoConstant.LOTTO_TICKET_PRICE +
                    "원 단위여야 합니다.");
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
