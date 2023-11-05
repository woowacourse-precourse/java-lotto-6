package lotto;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.IntStream;
import lotto.policy.LottoNumberGenerator;

public class LottoStore {
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoStore(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public SoldLotto sell(Amount purchaseAmount) {
        int lottoTicketCount = getLottoTicketCount(purchaseAmount);
        List<Lotto> lottos = IntStream.range(0, lottoTicketCount)
                .mapToObj(count -> generateLotto())
                .toList();
        return new SoldLotto(lottos);
    }

    private int getLottoTicketCount(Amount purchaseAmount) {
        BigInteger ticketCount = purchaseAmount.divide(Amount.DEFAULT_PURCHASE_AMOUNT);
        return ticketCount.intValue();
    }

    private Lotto generateLotto() {
        List<Integer> lottoNumber = lottoNumberGenerator.generate();
        return new Lotto(lottoNumber);
    }
}
