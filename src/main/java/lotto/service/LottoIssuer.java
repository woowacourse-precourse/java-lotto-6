package lotto.service;

import lotto.model.Lotto;
import lotto.model.PurchaseAmount;

import java.util.List;
import java.util.stream.IntStream;

public class LottoIssuer {

    private final Integer lottoTicket;
    private final Generator<Lotto> generator;

    private LottoIssuer(Integer lottoTicket, Generator<Lotto> generator) {
        this.lottoTicket = lottoTicket;
        this.generator = generator;
    }

    public static LottoIssuer of(PurchaseAmount purchaseAmount) {
        return new LottoIssuer(purchaseAmount.exchangeLottoTicket(), new LottoGenerator());
    }

    public List<Lotto> issueLotto() {
        return IntStream.range(0, lottoTicket)
                .mapToObj(idx -> generator.generate())
                .toList();
    }
}
