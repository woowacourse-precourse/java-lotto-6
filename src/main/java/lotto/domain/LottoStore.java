package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private final List<Lotto> lottoTickets;

    public LottoStore(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public LottoStore(Money money) {
        this.lottoTickets = purchaseLottoTickets(money);
    }

    private List<Lotto> purchaseLottoTickets(Money money) {
        List<Lotto> purchasedTickets = new ArrayList<>();
        LottoNumberGenerator numberGenerator = new LottoNumberGenerator();
        int buyableAmounts = money.getAmount() / Lotto.PRICE;
        for (int i = 0; i < buyableAmounts; i++) {
            purchasedTickets.add(numberGenerator.generateLotto());
        }
        return purchasedTickets;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public int getLottoAmounts() {
        return lottoTickets.size();
    }
}
