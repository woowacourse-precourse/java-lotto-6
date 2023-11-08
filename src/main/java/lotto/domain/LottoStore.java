package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    public static final int LOTTO_PRICE = 1000;
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoStore(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public Lottos purchaseLottoTickets(Money money) {
        List<Lotto> lottoTickets = new ArrayList<>();
        while (money.isEqualOrMoreThan(LOTTO_PRICE)) {
            lottoTickets.add(purchaseTicket(money));
        }
        return Lottos.from(lottoTickets);
    }

    private Lotto purchaseTicket(Money money) {
        money.decrease(LOTTO_PRICE);
        return lottoNumberGenerator.generate();
    }
}
