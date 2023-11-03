package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {
    private static final int STANDARD_OF_DIVIDE = 1000;
    private final List<Lotto> lottoTickets;

    private LottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets of(int purchasePrice, NumberGenerator lottoNumberGenerator) {
        int purchaseCount = calculatePurchaseCount(purchasePrice);
        List<Lotto> lottos = IntStream.range(0, purchaseCount)
                .mapToObj(i -> new Lotto(lottoNumberGenerator.generate()))
                .collect(Collectors.toList());
        return new LottoTickets(lottos);
    }

    private static int calculatePurchaseCount(int purchasePrice) {
        return purchasePrice / STANDARD_OF_DIVIDE;
    }

    public String getLottoTickets() {
        StringBuilder lottoPrinter = new StringBuilder();
        lottoTickets.stream()
                .forEach(lotto -> lottoPrinter.append(lotto).append("\n"));
        return lottoPrinter.toString();
    }

    public int size() {
        return lottoTickets.size();
    }
}
