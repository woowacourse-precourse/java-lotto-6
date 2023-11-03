package lotto.model;

import java.util.List;

public class LottoTicket {
    private List<Lotto> lotto;
    private int totalPurchaseAmount;

    private LottoTicket() {
    }

    private LottoTicket(List<Lotto> lotto, int totalPurchaseAmount) {
        this.lotto = lotto;
        this.totalPurchaseAmount = totalPurchaseAmount;
    }

    public static LottoTicket of(List<Lotto> lotto, int totalPurchaseAmount) {
        return new LottoTicket(lotto, totalPurchaseAmount);
    }
}
