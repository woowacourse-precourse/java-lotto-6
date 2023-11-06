package lotto;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.IntStream;
import lotto.policy.LottoNumbersGenerator;

public class LottoStore {
    private final LottoNumbersGenerator lottoNumbersGenerator;

    public LottoStore(LottoNumbersGenerator lottoNumbersGenerator) {
        this.lottoNumbersGenerator = lottoNumbersGenerator;
    }

    public SoldLotto sell(Amount purchaseAmount) {
        int lottoTicketCount = getLottoTicketCount(purchaseAmount);
        List<Lotto> lottoTickets = IntStream.range(0, lottoTicketCount)
                .mapToObj(count -> generateLotto())
                .toList();
        return new SoldLotto(lottoTickets);
    }

    private int getLottoTicketCount(Amount purchaseAmount) {
        BigInteger ticketCount = purchaseAmount.divide(Amount.DEFAULT_PURCHASE_AMOUNT);
        return ticketCount.intValue();
    }

    private Lotto generateLotto() {
        List<Integer> lottoNumbers = lottoNumbersGenerator.generate();
        return new Lotto(lottoNumbers);
    }
}
