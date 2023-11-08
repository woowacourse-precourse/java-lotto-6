package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.LottoGenerator;
import lotto.Validator.LottoValidator;

public class LottoSeller {

    public List<Lotto> exchangeTickets(int purchaseAmount) {
        LottoValidator.isValidPurchaseAmount(purchaseAmount);
        return createLottoTickets(calculateTicketCounts(purchaseAmount));
    }

    public List<Lotto> createLottoTickets(int lottoQuantity) {
        return IntStream.range(0, lottoQuantity)
                .mapToObj(i -> LottoGenerator.generateLottoNumbers())
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    private int calculateTicketCounts(int purchaseAmount) {
        return purchaseAmount / 1000;
    }
}
