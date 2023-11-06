package lotto.service;

import java.util.List;
import lotto.domain.Lotto;

public class LottoPurchaseService {
    private List<Lotto> lottoTicket;
    private int lottoEntryCount;
    public LottoPurchaseService() {
    }
    public void buyLottoTicket(String purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        lottoEntryCount = Integer.parseInt(purchaseAmount);
        // 갯수만큼 로또 구매(1. 로또 객체 생성, 2. )
    }

    private void validatePurchaseAmount(String purchaseAmount) {
        int amount;

        try {
            amount = Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (amount < 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
