package lotto.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.utils.NumberGenerator;

public class LottoService {

    private final NumberGenerator numberGenerator;

    public LottoService(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> createLottoTickets(int purchaseAmount) {
        int ticketCount = calculateNumberOfLottoTickets(purchaseAmount);
        return IntStream.range(0, ticketCount)
                .mapToObj(i -> new Lotto(numberGenerator.generateUniqueNumbers()))
                .collect(Collectors.toList());
    }

    public int calculateNumberOfLottoTickets(int purchaseAmount) {
        return purchaseAmount / 1000;
    }
}
