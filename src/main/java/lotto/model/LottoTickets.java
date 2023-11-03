package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private int quantity;
    private List<Lotto> lottoTickets;

    public LottoTickets(PurchaseAmount purchaseAmount) {
        quantity = calQuantity(purchaseAmount);
        lottoTickets = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            lottoTickets.add(new Lotto());
        }
    }

    private int calQuantity(PurchaseAmount purchaseAmount) {
        return purchaseAmount.getPurchaseAmount() / 1000;
    }
}
